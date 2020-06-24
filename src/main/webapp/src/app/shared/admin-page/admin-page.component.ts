import {Component, Input, OnInit} from '@angular/core';
import {Appeal, User} from '../interfaces';
import {HttpClient} from '@angular/common/http';
import set = Reflect.set;

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  appeals: Appeal[] = [];
  idusers: string [] = [];
  users: User [] = [];
  k: number;
  message: string;

  constructor(private http: HttpClient) {
    this.findAllAppeal();
    this.k = -1;
  }


  ngOnInit(): void {
  }

  findAllAppeal() {
    this.appeals.length = 0;
    this.http.get<Appeal[]>('http://localhost:8090/appeal/findall').subscribe(result => {
      for (const appeal of result) {
        this.appeals.push(appeal);
        this.idusers.push(appeal.userid);
      }
      this.finduser();
    });
  }

  finduser() {
    let arr = new Array();
    let user;
    const idset = new Set(this.idusers);
    for (const userid of idset) {
    }
    this.idusers = [];
    this.idusers = Array.from(idset);
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.idusers.length; i++) {
      console.log(this.idusers[i]);
      user =  new User();
      user.passenger_id = this.idusers[i];
      this.users[i] = user;
      this.users[i].expand = false;
      for (const appeal of this.appeals) {
        if (appeal.userid === this.users[i].passenger_id) {
          if (!this.users[i].firstname){
            this.users[i].firstname = appeal.firstname;
            this.users[i].lastname = appeal.lastname;
            this.users[i].middlename = appeal.middlename;
            this.users[i].phone = appeal.phone;
            this.users[i].email = appeal.email;
          }
          arr.push(appeal);
        }
        this.users[i].appeals = arr;
      }
      arr = [];
    }
  }

  expand(i) {
    this.users[i].expand = !this.users[i].expand;
  }
  read(i) {
    this.k = i;
  }
}


