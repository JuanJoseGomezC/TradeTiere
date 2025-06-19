package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested advertisment is not found.
 */
public class AdvertismentNotFoundException extends ResponseStatusException {

    public AdvertismentNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Anuncio no encontrado");
    }

    public AdvertismentNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
