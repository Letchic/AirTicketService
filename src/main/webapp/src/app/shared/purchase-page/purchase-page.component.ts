import {Component, OnInit} from '@angular/core';
import {Globals} from '../Globals';
import {Card, Flight} from '../interfaces';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-purchase-page',
  templateUrl: './purchase-page.component.html',
  styleUrls: ['./purchase-page.component.css']
})
export class PurchasePageComponent implements OnInit {


  constructor(private http: HttpClient, public globals: Globals) {
    this.currentFlight = JSON.parse(localStorage.getItem('currentFlight'));

  }

  currentFlight: Flight;
  message: string;

  cardnumber: string;
  cardholder: string;
  carddate: string;
  cvv: string;

  validcard: boolean;

  ngOnInit(): void {
    this.cardnumber = '4276 4200 0000 0001';
    this.cardholder = 'DMITRY PAKHOMOV';
    this.carddate = '03/21';
    this.cvv = '123';
  }

  checkcard() {
    if (!this.cardnumber) {
      this.message = 'Не указан номер карты!';
      return;
    }
    if (this.cardnumber.length < 16) {
      this.message = 'Не корректный номер карты!';
      return;
    }
    if (!this.cardholder) {
      this.message = 'Не указан владелец карты!';
      return;
    }

    if (!this.carddate) {
      this.message = 'Не указан срок действия карты!';
      return;
    }
    if (this.cardnumber.length < 5) {
      this.message = 'Не корректно указан срок действия карты!';
      return;
    }

    if (!this.cvv) {
      this.message = 'Не указан срок действия карты!';
      return;
    }
    if (this.cvv.length !== 3) {
      this.message = 'Не корректно указан cvv карты!';
      return;
    }

    const code = this.cardnumber.replace(/\s+/g, '');
    const cardholder = this.cardholder;
    const carddate = this.carddate;
    const cvv = this.cvv;
    return this.http.post<Response>('http://localhost:8090/card/pay', {code, cardholder, carddate, cvv}).subscribe(result => {
      if (result !== null && result.status === 200) {
        console.log('validcard');
        this.buyticket();
      } else {
        this.message = 'Не удалось провести платеж';
      }
    });
  }

  buyticket() {
    this.message = '';
    // tslint:disable-next-line:variable-name
    const flight_id = this.currentFlight.flightid;
    // tslint:disable-next-line:variable-name
    const passenger_id = this.globals.currentUser.passenger_id;
    const travelclass = this.currentFlight.travelclass;
    const isextraluggage = this.currentFlight.withlugg;
    const currentdate = new Date();
    const reservationdate = String(currentdate.getDay()).padStart(2, '0') + '-' + String((currentdate.getMonth() + 1)).padStart(2, '0')
      + '-' + currentdate.getFullYear() + ' '
      + String(currentdate.getHours()).padStart(2, '0') + ':'
      + String(currentdate.getMinutes()).padStart(2, '0') + ':' + String(currentdate.getSeconds()).padStart(2, '0');
    // tslint:disable-next-line:max-line-length
    return this.http.post<Response>('http://localhost:8090/ticket/buy', {
      flight_id,
      passenger_id,
      travelclass,
      isextraluggage,
      reservationdate
    }).subscribe(result => {
      document.location.href = '/account-page';
    });
  }
}
