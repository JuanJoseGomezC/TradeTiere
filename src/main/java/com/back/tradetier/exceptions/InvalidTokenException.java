package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when there's a problem with a token, such as invalid or expired tokens.
 */
public class InvalidTokenException extends ResponseStatusException {

    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "Token inválido o expirado");
    }

    public InvalidTokenException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
