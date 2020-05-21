package com.letchic.entity;

import javax.persistence.*;

@Entity
@Table(name = "travelclass")
public class TravelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long travelclassid;

    private String travelclass;

    @ManyToOne
    private Flight flight;
    private int emptyseats;
    private double price;


    public TravelClass() {
    }

    public TravelClass(String travelclass, Flight flight, int emptyseats, double price) {
        this.travelclass = travelclass;
        this.flight = flight;
        this.emptyseats = emptyseats;
        this.price = price;
    }

    public long getTravelclassid() {
        return travelclassid;
    }

    public void setTravelclassid(long travelclassid) {
        this.travelclassid = travelclassid;
    }

    public String getTravelclass() {
        return travelclass;
    }

    public void setTravelclass(String travelclass) {
        this.travelclass = travelclass;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getEmptyseats() {
        return emptyseats;
    }

    public void setEmptyseats(int emptyseats) {
        this.emptyseats = emptyseats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
