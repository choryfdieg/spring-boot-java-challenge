package com.busticket.app.controller;

import com.busticket.app.constant.URI;
import com.busticket.app.response.RestResponse;
import com.busticket.domain.entity.Booking;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookingApi {

    @PostMapping
    public ResponseEntity<RestResponse> createNewBooking(@Valid @RequestBody Booking booking);

    @GetMapping(URI.GET_BOOKING)
    public ResponseEntity<RestResponse> getBookingById(@PathVariable("id") String id);

    @GetMapping(URI.ALL_BOOKING)
    public ResponseEntity<RestResponse<List<Booking>>> getAllBookings();

    @PutMapping
    public ResponseEntity<RestResponse> updateBooking(@RequestBody Booking booking);

    @DeleteMapping(URI.DELETE_BOOKING)
    public ResponseEntity<RestResponse> deleteBookingById(@PathVariable("id") String id);
}
