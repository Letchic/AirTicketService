import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export interface Flight {
  flightid: string;
  startingpoint: string;
  destination: string;
  departuretime: string;
  tclass: string;
  onlydate: string;
  onlytime: string;
  price: number;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  flights: Flight[] = [];
  flightid: string;
  startingpoint: string;
  destination: string;
  departuretime: string;
  tclass: string;
  onlydate: string;
  onlytime: string;
  price: number;

  constructor(private http: HttpClient) {}

  findAll(){
    this.flights.length = 0;
    this.http.get<Flight[]>('http://localhost:8090/flight/findall').subscribe(result => {
      for (const flight of result) {
        console.log(flight)
        flight.onlydate = (flight.departuretime.substr(0, 10));
        flight.onlytime = (flight.departuretime.substr(11, 5));
        this.flights.push(flight);
      }
    });
  }

  find(startingpoint: string, destination: string, departuretime: string, tclass: string) {
    this.flights.length = 0;
    // tslint:disable-next-line:max-line-length
    this.http.get<Flight[]>('http://localhost:8090/flight/findwithparams?date='
      + departuretime + '&from=' + startingpoint + '&to=' + destination + '&travelclass=' + tclass).subscribe(result => {
      for (const flight of result) {
        console.log(flight)
        flight.onlydate = (flight.departuretime.substr(0, 10));
        flight.onlytime = (flight.departuretime.substr(11, 5));
        this.flights.push(flight);
      }
    });
  }
}
