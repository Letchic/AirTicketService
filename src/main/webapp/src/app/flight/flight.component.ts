import {Component, Input, OnInit} from '@angular/core';
import {Flight} from '../app.component';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  @Input() flights: Flight[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  buy(flights: Flight[], i: number) {
    console.log('You buy ticket on flight ' + flights[i].flightid);
  }
}
