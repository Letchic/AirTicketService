package com.letchic.views;

import java.util.Date;

public interface FlightView {
    long getFlightid();

    String getStartingpoint();

    String getDestination();

    double getPrice();

    double getLuggageprice();

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
