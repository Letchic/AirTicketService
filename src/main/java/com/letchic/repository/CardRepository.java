package com.letchic.repository;


import com.letchic.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Integer> {
    Card findByCodeAndCardholderAndCarddateAndCvv(String code, String cardholder, String carddate, String cvv);
}
