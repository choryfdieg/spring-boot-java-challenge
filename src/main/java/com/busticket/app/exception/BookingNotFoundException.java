package com.busticket.app.exception;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(String message){
        super(message);
    }

}
