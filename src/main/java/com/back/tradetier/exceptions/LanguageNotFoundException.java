package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a language is not found.
 */
public class LanguageNotFoundException extends ResponseStatusException {

    public LanguageNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Lenguaje no encontrado");
    }

    public LanguageNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
