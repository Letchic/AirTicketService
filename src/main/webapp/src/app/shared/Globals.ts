import {Injectable} from '@angular/core';
import {Flight, Ticket, User} from './interfaces';

@Injectable()

export class Globals {
  private params: any = [];
  currentUser: User;
  lugg: boolean;
  tclass: string;
  from: string;
  to: string;
  date: string;
  flight: Flight;
  ticket: Ticket

  constructor() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }
}
