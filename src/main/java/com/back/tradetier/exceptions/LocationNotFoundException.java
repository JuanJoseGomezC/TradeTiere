package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested location is not found.
 */
public class LocationNotFoundException extends ResponseStatusException {

    public LocationNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Ubicación no encontrada");
    }

    public LocationNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
