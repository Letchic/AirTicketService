package com.letchic.controller;

import com.letchic.model.Appeal;
import com.letchic.model.Flight;
import com.letchic.service.AppealService;
import com.letchic.service.FlightService;
import com.letchic.views.AppealView;
import com.letchic.views.FlightView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/appeal")
@CrossOrigin(origins = "http://localhost:4200")
public class AppealController {

    @Autowired
    private AppealService appealService;

    @GetMapping("/findall")
    public List<AppealView> findAppeals() {
        System.out.println("find appeal");
        return appealService.findAppeals();
    }
}
