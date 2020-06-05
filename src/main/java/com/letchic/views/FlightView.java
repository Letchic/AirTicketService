package com.letchic.views;

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
}
