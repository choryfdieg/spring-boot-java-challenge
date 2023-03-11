package com.busticket.domain.service;

import com.busticket.domain.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking findBookingById(String id);
    List<Booking> findAllBookings();
    Booking createBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(String id);
}
