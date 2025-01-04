package com.ardent.mailorderpharmacy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DrugNotFoundException extends RuntimeException{
    public DrugNotFoundException(String msg) {
        super(msg);
    }
}
