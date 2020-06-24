import {Component, OnInit} from '@angular/core';
import {Globals} from '../Globals';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public globals: Globals) {
  }

  ngOnInit(): void {
  }

  removeuser() {
    console.log('out');
    localStorage.removeItem('currentUser');
    this.globals.currentUser = null;
  }
}
