package com.letchic.service;

import com.letchic.model.Ticket;
import com.letchic.repository.TicketRepository;
import com.letchic.views.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public void create(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<TicketView> findTicket(long passenger_id) {
        System.out.println(passenger_id);
        return ticketRepository.findByPassenger_id(passenger_id);
    }

    public void callAddTicket(long flight_id) {
        ticketRepository.callAddTicket(flight_id);
    }

    public void updateTicket(long ticket_id, long passenger_id, boolean isextraluggage, String reservationdate) {
        ticketRepository.updateTicket(ticket_id, passenger_id, isextraluggage, reservationdate);
    }

    public long findFreeTicketID(long flight_id, String travelclass) {
        return ticketRepository.findFreeTicket(flight_id, travelclass).getTicket_id();
    }

    public Ticket checkTicket(long flightid, long passengerid) {
        return ticketRepository.checkTicket(flightid, passengerid);
    }

    public void cancelTicket(long ticket_id) {
        ticketRepository.cancelTicket(ticket_id);
    }
}
