package com.aiu.hotelrestapi.exception;

public class InvalidGuestException extends RuntimeException {

    public InvalidGuestException(String message) {
        super(message);
    }
}
