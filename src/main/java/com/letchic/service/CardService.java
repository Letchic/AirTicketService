package com.letchic.service;

import com.letchic.model.Card;
import com.letchic.repository.CardRepository;
import com.letchic.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card findByCodeAndCardholderAndCarddateAndCvv(String code, String cardholder, String carddate, String cvv) {
        return cardRepository.findByCodeAndCardholderAndCarddateAndCvv(code, cardholder, carddate, cvv);
    }
}
