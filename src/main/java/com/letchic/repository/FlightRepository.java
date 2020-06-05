package com.letchic.repository;

import com.letchic.model.Flight;
import com.letchic.views.FlightView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {


    String queryGetFlight ="SELECT * FROM Flight f JOIN travelclass t ON f.flightid = t.idflight AND t.travelclass=:travelclass "+
            "WHERE Date (f.departuretime) =  :date AND f.startingpoint = :spoint AND f.destination = :epoint";
    @Query(value = queryGetFlight, nativeQuery = true)
    List<FlightView> findByDeparturetimeAndPoints(@Param("date") Date date,
                                                  @Param("spoint") String spoint,
                                                  @Param("epoint") String epoint,
                                                  @Param("travelclass") String travelclass
    );

}
