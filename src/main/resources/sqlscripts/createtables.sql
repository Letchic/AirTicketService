CREATE TABLE IF NOT EXISTS users (
	passenger_id numeric PRIMARY KEY,
	email varchar(80) NOT NULL,
	password varchar(40) NOT NULL,
	firstname varchar(80) NOT NULL,
	lastname varchar(80) NOT NULL,
	middlename varchar(80) NOT NULL,
	gender varchar(10) NOT NULL,
	nationality varchar(80) NOT NULL,
	placeofbirth varchar(180) NOT NULL,
	dateofbirth varchar(80) NOT NULL,
	phone varchar(40) NOT NULL,
	passport varchar(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket (
	ticket_id numeric PRIMARY KEY,
	passenger_id numeric NOT NULL,
	flight_id numeric NOT NULL,
	travelclass varchar(10) NOT NULL,
	seat varchar(10) NOT NULL,
	status varchar(20) NOT NULL,
	reservationdate varchar(40) NOT NULL,
	isExtraLuggage	boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS flight (
	flightid bigint primary key generated always as identity ( START WITH   1000000000),
	departuretime timestamp  NOT NULL,
	startingpoint varchar(80) NOT NULL,
	destination varchar(80) NOT NULL,
	company varchar(80) NOT NULL,
	arrivaltime timestamp NOT NULL,
	luggageprice numeric NOT NULL,
	gate varchar(10) NOT NULL,
	UNIQUE(departuretime, startingpoint)
);

CREATE TABLE IF NOT EXISTS travelclass (
	travelclassid bigint primary key generated always as identity ( START WITH   2000000000),
	flightid bigint NOT NULL,
	travelclass varchar(20) NOT NULL,
	emptyseats numeric NOT NULL,
	price numeric NOT NULL,
	UNIQUE(flightid, travelclass)
);