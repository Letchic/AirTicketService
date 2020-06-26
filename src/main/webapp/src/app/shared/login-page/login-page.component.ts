import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../interfaces';
import {Globals} from '../Globals';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  @Input() email: string;
  @Input() password: string;
  @Input() public user: User;

  constructor(
    private http: HttpClient,
    private globals: Globals
  ) {
    this.user = globals.currentUser;
  }

  ngOnInit(): void {
  }

  login(email, password) {
    return this.http.post<User>('http://localhost:8090/user/auth/login', {email, password}).subscribe(result => {
      console.log(result);
      if (result) {
        this.user = result;
        if (this.user.passenger_id.toString() === '700000000') {
          document.location.href = '/admin-page';
          return;
        }
        this.globals.currentUser = this.user;
        localStorage.setItem('currentUser', JSON.stringify(this.user));
        document.location.href = '';
      }
    });
  }
}
