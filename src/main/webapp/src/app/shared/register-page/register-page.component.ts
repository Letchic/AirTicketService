import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../interfaces';


@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  @Input() email: string;
  @Input() password: string;
  @Input() firstname: string;
  @Input() lastname: string;
  @Input() middlename: string;
  @Input() gender: string;
  @Input() nationality: string;
  @Input() placeofbirth: string;
  @Input() dateofbirth: string;
  @Input() phone: string;
  @Input() passport: string;
  check: string;
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }
  register(email, password, firstname, lastname, middlename, gender, nationality, placeofbirth, dateofbirth, phone, passport) {
    this.check = '';
    // tslint:disable-next-line:max-line-length
    return this.http.post<Response>('http://localhost:8090/user/auth/register' , {email, password, firstname, lastname, middlename, gender, nationality, placeofbirth, dateofbirth, phone, passport}).subscribe(result => {
      console.log(result);
      if ( result.status === 208)     {
       this.check = 'Пользователь с таким email уже существует';
      }
      if ( result.status === 200)     {
        document.location.href = '/login-page';
      }
    });
  }
}
