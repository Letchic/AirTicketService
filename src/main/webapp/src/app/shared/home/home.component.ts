import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Flight} from '../interfaces';
import {Globals} from '../Globals';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  flights: Flight[] = [];
  startingpoint: string;
  destination: string;
  departuretime: string;
  lugg: boolean;
  tclass: string;
  date1: Date;
  date2: Date;
  search: boolean;
  nonecity: boolean;
  nonedata: boolean;

  constructor(private http: HttpClient,
              public globals: Globals
  ) {
    this.lugg = false;
    this.tclass = 'econom';
    /*
    this.startingpoint = 'Москва';
    this.destination = 'Рим';
    this.departuretime = '2020-07-01';
    this.search = false;*/
  }

  ngOnInit(): void {
  }

  findAll() {
    this.globals.lugg = this.lugg;
    this.globals.tclass = this.tclass;
    this.flights.length = 0;
    this.http.get<Flight[]>('http://localhost:8090/flight/findall').subscribe(result => {
      for (const flight of result) {
        console.log(flight);
        this.flights.push(flight);
      }
    });
  }

  find() {
    this.search = false;
    this.nonecity = false;
    this.nonedata = false;
    if (!this.startingpoint || !this.destination) {
    this.nonecity = true;
    this.flights = [];
    return;
    }
    if (!this.departuretime) {
      this.nonedata = true;
      this.flights = [];
      return;
    }
    this.globals.lugg = this.lugg;
    this.globals.tclass = this.tclass;
    console.log(this.globals.lugg);
    this.flights.length = 0;
    // tslint:disable-next-line:max-line-length startingpoint, destination, departuretime
    this.http.get<Flight[]>('http://localhost:8090/flight/findwithparams?date='
      // tslint:disable-next-line:max-line-length
      + this.departuretime + '&from=' + this.startingpoint + '&to=' + this.destination + '&travelclass=' + this.globals.tclass).subscribe(result => {
      for (const flight of result) {
        console.log(flight);
        this.date1 = new Date(flight.departuretime);
        this.date2 = new Date(flight.arrivaltime);
        flight.onlydate = (this.date1.toLocaleDateString());
        flight.onlytime = (this.date1.toLocaleString().substr(12, 5));
        flight.onlydate2 = (this.date2.toLocaleDateString());
        flight.onlytime2 = (this.date2.toLocaleString().substr(12, 5));
        flight.time = this.msToTime(this.date1, this.date2);
        flight.withlugg = false;
        flight.totalprice = flight.price;
        this.flights.push(flight);
      }
      this.search = true;
    });
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

  swap(){
    const temp = this.startingpoint;
    this.startingpoint = this.destination;
    this.destination = temp;
  }
}

