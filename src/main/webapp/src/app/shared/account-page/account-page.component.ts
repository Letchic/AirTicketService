import {Component, OnInit} from '@angular/core';
import {Globals} from '../Globals';
import {Ticket} from '../interfaces';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  constructor(private http: HttpClient, public globals: Globals) {
  }

  tickets: Ticket[] = [];
  date1: Date;
  date2: Date;

  findTickets() {
    this.http.get<Ticket[]>('http://localhost:8090/ticket/findticket?passenger_id='
      + this.globals.currentUser.passenger_id).subscribe(result => {
      for (const ticket of result) {
        console.log(ticket);

        this.date1 = new Date(ticket.departuretime);
        this.date2 = new Date(ticket.arrivaltime);
        ticket.onlydate = (this.date1.toLocaleDateString());
        ticket.onlytime = (this.date1.toLocaleString().substr(12, 5));
        ticket.onlydate2 = (this.date2.toLocaleDateString());
        ticket.onlytime2 = (this.date2.toLocaleString().substr(12, 5));
        ticket.time = this.msToTime(this.date1, this.date2);
        this.tickets.push(ticket);
      }
    });
  }

  ngOnInit(): void {
    setTimeout(
      () => {
        this.tickets = [];
        this.findTickets();
      },
      100
    );
  }

  msToTime(date1, date2) {
    let duration;
    let minutes;
    let hours;
    duration = date2 - date1;
    minutes = Math.floor((duration / (1000 * 60)) % 60);
    hours = Math.floor((duration / (1000 * 60 * 60)) % 24);
    hours = (hours < 10) ? '0' + hours : hours;
    minutes = (minutes < 10) ? '0' + minutes : minutes;
    return hours + 'ч ' + minutes + 'м';
  }

  cancel(i) {
    localStorage.setItem('returnticket', JSON.stringify(this.tickets[i]));
  }

  sendtoemail(i) {
    const text = 'Билет: ' + this.tickets[i].ticket_id + '\n' +
      'Рейс: ' + this.tickets[i].flightid + '\n' +
      'Вылет: ' + this.tickets[i].airport1city + ' (' + this.tickets[i].startingpoint + ') \n' +
      'Дата и время вылета: ' + this.tickets[i].onlydate + ' ' + this.tickets[i].onlytime + '\n' +
      'Посадка: ' + this.tickets[i].airport2city + ' (' + this.tickets[i].destination + ') \n' +
      'Дата и время посадки: ' + this.tickets[i].onlydate2 + ' ' + this.tickets[i].onlytime2 + '\n' +
      'Класс: ' + (this.tickets[i].travelclass === 'econom' ? 'эконом' : 'бизнес') + '\n' +
      'Место: ' + this.tickets[i].seat;
    const email = this.globals.currentUser.email;

    return this.http.post('http://localhost:8090/ticket/send', {text, email}).subscribe(result => {
    });
  }
}
