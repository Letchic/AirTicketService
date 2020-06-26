package com.letchic.controller;

import com.letchic.exception.AlreadyAddedException;
import com.letchic.model.Flight;
import com.letchic.model.Message;
import com.letchic.model.Ticket;
import com.letchic.service.EmailService;
import com.letchic.service.FlightService;
import com.letchic.service.TicketService;
import com.letchic.views.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    FlightService flightService;
    @Autowired
    TicketService ticketService;
    @Autowired
    EmailService emailService;

    @PostMapping("/buy")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful ticket")
    public void updateTickets(@RequestBody Ticket ticket) {
        long ticket_id = ticketService.findFreeTicketID(ticket.getFlight_id(), ticket.getTravelclass());
        ticketService.updateTicket(ticket_id, ticket.getPassenger_id(), ticket.isIsextraluggage(), ticket.getReservationdate());
    }

    @GetMapping("/findticket")
    public List<TicketView> findTicket(@RequestParam long passenger_id) {
        return ticketService.findTicket(passenger_id);
    }

    @GetMapping("/checkticket")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful ticket")
    public void checkTicket(@RequestParam long flightid, long userid) throws AlreadyAddedException {
        if (ticketService.checkTicket(flightid, userid) != null) throw new AlreadyAddedException();
    }


    @PostMapping("/createtickets")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful ticket")
    public void createTickets() {
        List<Flight> flightList = flightService.findAll();
        for (Flight f : flightList) {
            ticketService.callAddTicket(f.getFlightid());
        }
    }

    @PostMapping("/cancel")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful ticket")
    public void cancel(@RequestBody Ticket ticket) {
        ticketService.cancelTicket(ticket.getTicket_id());
    }

    @PostMapping("/send")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful send")
    public void send(@RequestBody Message message) {
        emailService.sendPreConfiguredMail(message.getEmail(), message.getText());
    }


}
