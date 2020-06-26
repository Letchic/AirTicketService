export interface Flight {
  flightid: string;
  startingpoint: string;
  destination: string;
  departuretime: string;
  arrivaltime: string;
  travelclass: string;
  onlydate: string;
  onlytime: string;
  onlydate2: string;
  onlytime2: string;
  price: number;
  luggageprice: number;
  airport1name: string;
  airport2name: string;
  airport1city: string;
  airport2city: string;
  time: string;
  company: string;
  totalprice: number;
  withlugg: boolean;
}

export class User {
  // tslint:disable-next-line:variable-name
  passenger_id: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  middlename: string;
  gender: string;
  nationality: string;
  placeofbirth: string;
  dateofbirth: string;
  phone: string;
  passport: string;
  messages: ChatMessage[];
  expand: boolean;
  fio: string;
}

export interface Response {
  status: string;
}

export interface Ticket {
  flightid: string;
  startingpoint: string;
  destination: string;
  departuretime: string;
  arrivaltime: string;
  ticket_id: string;
  airport1name: string;
  airport2name: string;
  airport1city: string;
  airport2city: string;
  time: string;
  company: string;
  onlydate: string;
  onlytime: string;
  onlydate2: string;
  onlytime2: string;
  travelclass: string;
  seat: string;
}

export interface Card {
  cardnumber: string;
  cardholder: string;
  carddate: string;
  cvv: string;
}

export class ChatMessage {
  messageid: string;
  useridfrom: string;
  useridto: string;
  message: string;
  date: string;
  userfiofrom: string;
  userfioto: string;

  constructor(useridfrom: string, useridto: string,
              message: string, date: string) {
    this.useridfrom = useridfrom;
    this.useridto = useridto;
    this.message = message;
    this.date = date;
  }

}
