package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested species is not found.
 */
public class SpecieNotFoundException extends ResponseStatusException {

    public SpecieNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Especie no encontrada");
    }

    public SpecieNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
