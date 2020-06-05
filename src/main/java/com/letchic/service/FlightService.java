package com.letchic.service;

import com.letchic.model.Flight;
import com.letchic.repository.FlightRepository;

import com.letchic.views.FlightView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

   public List<FlightView> findByDeparturetimeAndPoints(Date date, String spoint, String epoint, String travelclass){

        return flightRepository.findByDeparturetimeAndPoints(date,spoint,epoint,travelclass);

    }

}
