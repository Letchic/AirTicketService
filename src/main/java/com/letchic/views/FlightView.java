package com.letchic.views;

import java.sql.Time;
import java.util.Date;

public interface FlightView {
    long getFlightid();

    String getStartingpoint();

    String getDestination();

    double getPrice();

    double getLuggageprice();

    int getEmptyseats();

    Date getDeparturetime();

    Date getArrivaltime();

    String getGate();

    String getTravelclass();

    String getAirport1name();

    String getAirport2name();

    String getAirport1city();

    String getAirport2city();

    String getCompany();
}
