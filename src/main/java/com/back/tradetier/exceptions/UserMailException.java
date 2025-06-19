package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserMailException extends ResponseStatusException {

    public UserMailException(){
        super(HttpStatus.NOT_FOUND,"Mail no encontrado");
    }
}