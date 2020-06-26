package com.letchic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NotFoundException extends Exception {
    public String toString() {
        return ("Not found");
    }
}
