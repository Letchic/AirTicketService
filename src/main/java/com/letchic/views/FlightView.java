package com.letchic.views;

public interface FlightView {
    long getFlightid();
    String getStartingpoint();
    String getDestination();
    double getPrice();
    double getLuggageprice();
    int getEmptyseats();
}
