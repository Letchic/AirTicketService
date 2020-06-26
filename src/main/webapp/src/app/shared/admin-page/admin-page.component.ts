import {Component, OnInit} from '@angular/core';
import {ChatMessage, User} from '../interfaces';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  users: User [] = [];
  k: number;
  message: string;
  chatmessage: ChatMessage;

  constructor(private http: HttpClient) {
    this.finduser();
    this.k = -1;
  }


  ngOnInit(): void {
  }

  finduser() {
    this.http.get<User[]>('http://localhost:8090/user/finduserwithmessage').subscribe(result => {
      for (const user of result) {
        if ('700000000' !== user.passenger_id) {
          console.log(user);
          this.users.push(user);
        }
      }
    });
  }

  sendmessage() {
    const currentdate = new Date();
    const senddate = String(currentdate.getUTCDate()).padStart(2, '0') + '-' + String((currentdate.getMonth() + 1)).padStart(2, '0')
      + '-' + currentdate.getFullYear() + ' '
      + String(currentdate.getHours()).padStart(2, '0') + ':'
      + String(currentdate.getMinutes()).padStart(2, '0');

    this.chatmessage = new ChatMessage('700000000',
      this.users[this.k].passenger_id,
      this.message,
      senddate);
    console.log(this.chatmessage);
    return this.http.post('http://localhost:8090/chatmessage/create', this.chatmessage).subscribe(result => {
     this.message = '';
     this.findmessage();
    });
  }

  findmessage() {
    this.users[this.k].messages = [];
    this.http.get<ChatMessage[]>('http://localhost:8090/chatmessage/findamessages?userid=' + this.users[this.k].passenger_id)
      .subscribe(result => {
      for (const message of result) {
        this.users[this.k].messages.push(message);
      }
    });
  }

  expand(i) {
    this.users[i].expand = !this.users[i].expand;
  }

  read(i) {
    this.k = i;
    this.findmessage();
  }
}


