package com.example.vendingmachine.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends JsonProcessingException {

    public RecordNotFoundException(String message) {
        super(message);
    }

}
