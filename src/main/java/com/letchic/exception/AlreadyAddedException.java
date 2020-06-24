package com.letchic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "User already added")
public class AlreadyAddedException extends Exception{
    public String toString() {
        return ("User already added");
    }
}
