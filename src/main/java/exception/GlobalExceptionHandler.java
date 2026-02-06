package com.aiu.hotelrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<String> handleNotFound(GuestNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidGuestException.class)
    public ResponseEntity<String> handleInvalid(InvalidGuestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
