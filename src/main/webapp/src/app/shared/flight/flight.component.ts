import {Component, Input, OnInit,} from '@angular/core';
import {Flight, User} from '../interfaces';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../Globals';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {


  @Input() flights: Flight[] = [];
  check: string;

  constructor(private http: HttpClient,
              private globals: Globals) {
  }

  ngOnInit(): void {
  }

  setFlight(isextraluggage, i) {
    if (!this.globals.currentUser) {
      document.location.href = '/login-page';
    } else {
      this.chekticket(isextraluggage, i);
    }
  }

  setprice(withlugg, i) {
    if (withlugg) {
      this.flights[i].withlugg = true;
      this.flights[i].totalprice = this.flights[i].price + this.flights[i].luggageprice;
    } else {
      this.flights[i].withlugg = false;
      this.flights[i].totalprice = this.flights[i].price;
    }
  }

   chekticket(isextraluggage, i) {
    this.http.get<Response>('http://localhost:8090/ticket/checkticket?flightid='
      + this.flights[i].flightid + '&userid=' + this.globals.currentUser.passenger_id).subscribe(result => {
      console.log('check ticket');
      console.log(result);
      if ( result.status === 208)     {
        document.location.href = '/app-alreadybuyed';
      }
      if ( result.status === 200){
        localStorage.removeItem('currentFlight');
        this.flights[i].withlugg = isextraluggage;
        this.flights[i].travelclass = this.globals.tclass;
        localStorage.setItem('currentFlight', JSON.stringify(this.flights[i]));
        document.location.href = '/parchase-page';
      }
    });
  }
}
