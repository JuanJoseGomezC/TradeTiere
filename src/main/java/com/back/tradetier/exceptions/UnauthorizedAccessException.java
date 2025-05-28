package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a user tries to access a resource they are not authorized to access.
 */
public class UnauthorizedAccessException extends ResponseStatusException {

    public UnauthorizedAccessException() {
        super(HttpStatus.FORBIDDEN, "No estás autorizado para acceder a este recurso");
    }

    public UnauthorizedAccessException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
