package com.letchic.controller;


import com.letchic.exception.AlreadyAddedException;
import com.letchic.exception.NotFoundException;
import com.letchic.model.Card;
import com.letchic.model.User;
import com.letchic.service.CardService;
import com.letchic.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {

    @Autowired
    private CardService cardService;


    @PostMapping("/pay")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful pay")
    public void creategetUser(@RequestBody Card card) throws NotFoundException {
        System.out.println("string " + card.toString());
        if (cardService.findByCodeAndCardholderAndCarddateAndCvv(card.getCode(), card.getCardholder(), card.getCarddate(), card.getCvv()) != null) {
            System.out.println("found " + card);
        } else {
            System.out.println("not found " + card);
            throw new NotFoundException();
        }
    }

}



