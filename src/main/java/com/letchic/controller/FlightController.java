package com.letchic.controller;

import com.letchic.model.Flight;
import com.letchic.service.FlightService;
import com.letchic.views.FlightView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/findwithparams")
    public List<FlightView> getFlight(@RequestParam String date, String from, String to, String travelclass) {
        return flightService.findByDeparturetimeAndPoints(Date.valueOf(date), from, to, travelclass);
    }

    @GetMapping("/findall")
    public List<Flight> findAll() {
        return flightService.findAll();
    }
}
