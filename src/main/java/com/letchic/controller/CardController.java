package com.letchic.controller;


import com.letchic.exception.NotFoundException;
import com.letchic.model.Card;
import com.letchic.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/card")
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/pay")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful pay")
    public void creategetUser(@RequestBody Card card) throws NotFoundException {
        if (cardService.findByCodeAndCardholderAndCarddateAndCvv(card.getCode(),
                card.getCardholder(), card.getCarddate(),
                card.getCvv()) == null) throw new NotFoundException();
    }
}



