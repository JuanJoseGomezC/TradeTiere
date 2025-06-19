package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested race is not found.
 */
public class RaceNotFoundException extends ResponseStatusException {

    public RaceNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Raza no encontrada");
    }

    public RaceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
