package com.busticket.app.controller;

import com.busticket.app.constant.URI;
import com.busticket.app.response.RestResponse;
import com.busticket.domain.constant.Message;
import com.busticket.domain.entity.Booking;
import com.busticket.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URI.BASE_BOOKING_API)
public class BookingMongoRestController implements BookingApi {

    private final BookingService service;

    @Autowired
    public BookingMongoRestController(BookingService service) {
        this.service = service;
    }

    public ResponseEntity<RestResponse> createNewBooking(Booking booking) {

        Booking newBooking = service.createBooking(booking);

        return ResponseEntity
                .created(java.net.URI.create(URI.GET_BOOKING.replace("{id}", newBooking.getId())))
                .body(new RestResponse<>(newBooking, Message.BOOKING_CREATE_SUCCESS));

    }

    public ResponseEntity<RestResponse> getBookingById(String id) {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.findBookingById(id)));

    }

    public ResponseEntity<RestResponse<List<Booking>>> getAllBookings() {

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(service.findAllBookings()));

    }

    public ResponseEntity<RestResponse> updateBooking(Booking booking) {

        service.updateBooking(booking);

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(true, Message.BOOKING_UPDATE_SUCCESS));

    }

    public ResponseEntity<RestResponse> deleteBookingById(String id) {

        service.deleteBooking(id);

        return ResponseEntity.status(HttpStatus.OK).body(new RestResponse<>(true, Message.BOOKING_DELETE_SUCCESS));

    }
}
