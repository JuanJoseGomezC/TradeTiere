package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserLoginException extends ResponseStatusException {

    public UserLoginException(){
        super(HttpStatus.FORBIDDEN,"Usuario o contraseña incorrectos");
    }
}