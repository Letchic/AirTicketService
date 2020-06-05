package com.letchic.model;

import javax.persistence.*;

    @Entity
    @Table(name = "ticket")
    public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long ticket_id;

        private long passenger_id;
        private long flight_id;
        private String travelclass;
        private String seat;
        private String status;
        private String reservationdate;
        private boolean nationality;

        public Ticket() {
        }

        public Ticket(long passenger_id, long flight_id, String travelclass, String seat, String status, String reservationdate, boolean nationality) {
            this.passenger_id = passenger_id;
            this.flight_id = flight_id;
            this.travelclass = travelclass;
            this.seat = seat;
            this.status = status;
            this.reservationdate = reservationdate;
            this.nationality = nationality;
        }
    }
