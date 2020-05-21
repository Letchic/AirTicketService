package com.letchic.controller;

import com.letchic.entity.Flight;
import com.letchic.service.FlightService;
import com.letchic.views.FlightView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController  {

    @Autowired
    private FlightService flightService;

    @GetMapping("/findwithparams")
    public List<FlightView> getFlight(String date,String from, String to, String travelclass) {
        return flightService.findByDeparturetimeAndPoints(Date.valueOf(date),from,to,travelclass);
    }

    @GetMapping ("/findall")
    public List<Flight> findAll () {
        return flightService.findAll();
    }

}