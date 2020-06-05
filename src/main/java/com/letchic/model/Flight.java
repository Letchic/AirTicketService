package com.letchic.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightid;

    private Timestamp departuretime;
    private String startingpoint;
    private String destination;
    private String company;
    private String arrivaltime;
    private double luggageprice;
    private String gate;
    public Flight() {
    }

    public Flight(Timestamp departuretime, String startingpoint, String destination, String company, String arrivaltime, double luggageprice, String gate) {
        this.departuretime = departuretime;
        this.startingpoint = startingpoint;
        this.destination = destination;
        this.company = company;
        this.arrivaltime = arrivaltime;
        this.luggageprice = luggageprice;
        this.gate = gate;
    }

    public long getFlightid() {
        return flightid;
    }

    public void setFlightid(long flightid) {
        this.flightid = flightid;
    }

    public Timestamp getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Timestamp departuretime) {
        this.departuretime = departuretime;
    }

    public String getStartingpoint() {
        return startingpoint;
    }

    public void setStartingpoint(String startingpoint) {
        this.startingpoint = startingpoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public double getLuggageprice() {
        return luggageprice;
    }

    public void setLuggageprice(double luggageprice) {
        this.luggageprice = luggageprice;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightid=" + flightid +
                ", departuretime=" + departuretime +
                ", startingpoint='" + startingpoint + '\'' +
                ", destination='" + destination + '\'' +
                ", company='" + company + '\'' +
                ", arrivaltime='" + arrivaltime + '\'' +
                ", luggageprice=" + luggageprice +
                ", gate='" + gate + '\'' +
                '}';
    }
}
