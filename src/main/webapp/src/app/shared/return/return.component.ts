import {Component, OnInit} from '@angular/core';
import {Globals} from '../Globals';
import {HttpClient} from '@angular/common/http';
import {Ticket} from '../interfaces';

@Component({
  selector: 'app-return',
  templateUrl: './return.component.html',
  styleUrls: ['./return.component.css']
})
export class ReturnComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  number: string;
  ticket: Ticket;

  ngOnInit(): void {
    this.ticket = JSON.parse(localStorage.getItem('returnticket'));
  }

  cancel() {
    this.http.post<Response>('http://localhost:8090/ticket/cancel', this.ticket).subscribe(result => {
      document.location.href = '/account-page';
    });
  }
}
