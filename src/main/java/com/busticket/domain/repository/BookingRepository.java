package com.busticket.domain.repository;

import com.busticket.domain.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    Optional<Booking> findById(String id);
    List<Booking> findAll();
    Optional<Booking> save(Booking booking);
    void delete(Booking booking);

}
