package com.letchic.views;

import java.util.Date;

public interface TicketView {
    long getFlightid();

    String getStartingpoint();

    String getDestination();

    Date getDeparturetime();

    Date getArrivaltime();

    String getGate();

    String getTicket_id();

    String getTravelclass();

    String getAirport1name();

    String getAirport2name();

    String getAirport1city();

    String getAirport2city();

    String getCompany();
}
