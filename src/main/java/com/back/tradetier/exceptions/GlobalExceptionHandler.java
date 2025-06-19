package com.back.tradetier.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);    
    
    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<String> handleLoginException(ResponseStatusException ex){
        log.warn("Login error: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<String> handleConflict(ResponseStatusException ex){
        log.warn("User conflict: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(UserMailException.class)
    public ResponseEntity<String> handleUserMailException(ResponseStatusException ex){
        log.warn("User mail error: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        log.warn("Resource not found: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<String> handleUnauthorizedAccess(ResponseStatusException ex) {
        log.warn("Unauthorized access: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }
    
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<String> handleInvalidToken(ResponseStatusException ex) {
        log.warn("Invalid token: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }
      @ExceptionHandler({
        RaceNotFoundException.class,
        SpecieNotFoundException.class,
        LocationNotFoundException.class,
        PurchaseHistoryNotFoundException.class,
        LanguageNotFoundException.class,
        AdvertismentNotFoundException.class
    })
    public ResponseEntity<String> handleEntityNotFound(ResponseStatusException ex) {
        log.warn("Entity not found: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }


    // Para cualquier otra excepción no controlada    @ExceptionHandler(jakarta.persistence.EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(jakarta.persistence.EntityNotFoundException ex) {
        log.warn("Entity not found: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Error interno del servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
