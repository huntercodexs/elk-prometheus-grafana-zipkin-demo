package com.huntercodexs.orderdemo.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AddOrderException extends RuntimeException {
    public AddOrderException(String message) {
        super(message);
    }
}
