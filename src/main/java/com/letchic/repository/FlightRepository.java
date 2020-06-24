package com.letchic.repository;

import com.letchic.model.Flight;
import com.letchic.views.FlightView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    String queryGetFlightId = "WITH flightId \n" +
            "AS  \n" +
            "(  \n" +
            "SELECT flightid, startingpoint, destination, luggageprice, departuretime, arrivaltime, gate, company\n" +
            "FROM flight JOIN airports ON code = startingpoint \n" +
            "WHERE city = :spoint  AND Date (departuretime) = :date\n" +
            "INTERSECT \n" +
            "SELECT flightid, startingpoint, destination, luggageprice, departuretime, arrivaltime, gate, company\n" +
            "FROM flight JOIN airports ON code = destination\n" +
            "WHERE city = :epoint    \n" +
            ")  \n" +
            "SELECT flightid, startingpoint, destination, luggageprice, departuretime, arrivaltime, gate, company,\n" +
            "travelclass,emptyseats,price, \n" +
            "airport1.airportname AS airport1name, airport1.city AS airport1city, \n" +
            "airport2.airportname AS airport2name, airport2.city AS airport2city\n" +
            "FROM flightId f JOIN travelclass t ON f.flightid = t.idflight AND t.travelclass=:travelclass\n" +
            "JOIN  airports as airport1 ON airport1.code = startingpoint\n" +
            "JOIN  airports as airport2 ON airport2.code = destination";

    @Query(value = queryGetFlightId, nativeQuery = true)
    List<FlightView> findByDeparturetimeAndPoints(@Param("date") Date date,
                                                  @Param("spoint") String spoint,
                                                  @Param("epoint") String epoint,
                                                  @Param("travelclass") String travelclass
    );

    List<Flight> findAll();

}
