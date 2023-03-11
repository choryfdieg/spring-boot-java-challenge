package com.busticket.app.controller;

import com.busticket.app.response.RestResponse;
import com.busticket.domain.entity.Booking;
import com.busticket.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking-mongo")
public class BookingMongoRestController implements BookingApi {

    private final BookingService service;

    @Autowired
    public BookingMongoRestController(BookingService service) {
        this.service = service;
    }

    public ResponseEntity<RestResponse> createNewBooking(Booking booking) {

        return ResponseEntity.status(HttpStatus.CREATED).body(new RestResponse<>(service.createBooking(booking)));

    }

    public ResponseEntity<RestResponse> getBookingById(String id) {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.findBookingById(id)));

    }

    public ResponseEntity<RestResponse<List<Booking>>> getAllBookings() {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.findAllBookings()));

    }

    public ResponseEntity<RestResponse> updateBooking(Booking booking) {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.updateBooking(booking)));

    }

    public ResponseEntity<RestResponse> deleteBookingById(String id) {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.deleteBooking(id)));

    }
}
