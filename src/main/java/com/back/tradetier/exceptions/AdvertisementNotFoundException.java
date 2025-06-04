package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested advertisement is not found.
 */
public class AdvertisementNotFoundException extends ResponseStatusException {

    public AdvertisementNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Anuncio no encontrado");
    }

    public AdvertisementNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
