package com.letchic.service;

import com.letchic.model.Appeal;
import com.letchic.model.Flight;
import com.letchic.repository.AppealRepository;
import com.letchic.views.AppealView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppealService {

    @Autowired
    private AppealRepository appealRepository;

    public List<AppealView> findAppeals() {
        return appealRepository.findAppeals();
    }
}
