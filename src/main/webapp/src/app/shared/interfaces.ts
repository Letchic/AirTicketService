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
  appeals: Appeal[];
  expand: boolean;
  public userid: string;
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
}

export interface Card
{
  cardnumber: string;
  cardholder: string;
  carddate: string;
  cvv: string;
}

export interface Appeal{
  appealid: string ;
  userid: string ;
  message: string ;
  date: string ;
  firstname: string;
  lastname: string;
  middlename: string;
  phone: string;
  email: string;
}
