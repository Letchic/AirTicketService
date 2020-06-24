package com.letchic.repository;

import com.letchic.model.Ticket;
import com.letchic.views.TicketView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket save(Ticket ticket);



    String queryCheckTicket = "SELECT * FROM ticket\n" +
            "WHERE flight_id = :flight_id AND passenger_id = :passenger_id";

    @Query(value = queryCheckTicket, nativeQuery = true)
    Ticket checkTicket(@Param("flight_id") long flight_id,
                       @Param("passenger_id") long passenger_id);



    String queryGetTicket = "SELECT ticket_id, flightid, startingpoint, destination, departuretime, arrivaltime, gate,\n" +
            "travelclass, company,\n" +
            "a1.airportname AS airport1name, a1.city AS airport1city, \n" +
            "a2.airportname AS airport2name, a2.city AS airport2city \n" +
            "FROM flight f \n" +
            "JOIN ticket tck ON f.flightid = tck.flight_id\n" +
            "JOIN airports a1 ON f.startingpoint = a1.code\n" +
            "JOIN airports a2 ON f.destination = a2.code\n" +
            "WHERE tck.passenger_id = :passenger_id";

    @Query(value = queryGetTicket, nativeQuery = true)
    List<TicketView> findByPassenger_id(@Param("passenger_id") long passenger_id);

    String queryAddTicket = "SELECT add_tckf(:flight_id)";

    @Query(value = queryAddTicket, nativeQuery = true)
    void callAddTicket(@Param("flight_id") long flight_id);

    String queryUpdateTicket = "UPDATE ticket \n" +
            "SET status = 'buy', passenger_id = :passenger_id,\n" +
            "isextraluggage = :isextraluggage, reservationdate = :reservationdate\n" +
            "WHERE ticket_id = :ticket_id";

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = queryUpdateTicket, nativeQuery = true)
    void updateTicket(@Param("ticket_id") long ticket_id,
                      @Param("passenger_id") long passenger_id,
                      @Param("isextraluggage") boolean isextraluggage,
                      @Param("reservationdate") String reservationdate);

    String queryGetFreeTicket = "SELECT * FROM ticket\n" +
            "WHERE flight_id = :flight_id AND travelclass = :travelclass AND status = 'free'\n" +
            "ORDER BY ticket_id LIMIT 1";

    @Query(value = queryGetFreeTicket, nativeQuery = true)
    Ticket findFreeTicket(@Param("flight_id") long flight_id,
                          @Param("travelclass") String travelclass);


    String queryCancelTicket = "UPDATE ticket \n" +
            "SET status = 'free', passenger_id = '0', \n" +
            "isExtraLuggage = false, reservationdate = 'none'\n" +
            "WHERE ticket_id = :ticket_id";

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = queryCancelTicket, nativeQuery = true)
    void cancelTicket(@Param("ticket_id") long ticket_id);
}
