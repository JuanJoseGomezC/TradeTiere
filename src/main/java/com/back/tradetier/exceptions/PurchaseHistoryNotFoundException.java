package com.back.tradetier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception thrown when a requested purchase history is not found.
 */
public class PurchaseHistoryNotFoundException extends ResponseStatusException {

    public PurchaseHistoryNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Historial de compra no encontrado");
    }

    public PurchaseHistoryNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
