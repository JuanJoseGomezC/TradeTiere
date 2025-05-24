package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserExistException extends ResponseStatusException {

    public UserExistException(){
        super(HttpStatus.CONFLICT,"El correo ya esta en uso");
    }
}