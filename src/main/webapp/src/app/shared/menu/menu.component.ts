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

  sendmessage() {
    const currentdate = new Date();
    const senddate = String(currentdate.getUTCDate()).padStart(2, '0') + '-' + String((currentdate.getMonth() + 1)).padStart(2, '0')
      + '-' + currentdate.getFullYear() + ' '
      + String(currentdate.getHours()).padStart(2, '0') + ':'
      + String(currentdate.getMinutes()).padStart(2, '0');
    console.log(senddate);
  }
}
