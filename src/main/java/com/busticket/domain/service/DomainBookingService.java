package com.busticket.domain.service;

import com.busticket.app.exception.BookingDeleteException;
import com.busticket.app.exception.BookingNotFoundException;
import com.busticket.app.exception.BookingSaveException;
import com.busticket.domain.entity.Booking;
import com.busticket.domain.repository.BookingRepository;

import java.util.List;

public class DomainBookingService implements BookingService{

    private final BookingRepository repository;

    public DomainBookingService(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking findBookingById(String id) {
        return repository.findById(id).orElseThrow(()->{
            throw new BookingNotFoundException("No Booking was found with id: " + id);
        });
    }

    @Override
    public List<Booking> findAllBookings() {
        return repository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return repository.save(booking).orElseThrow(()->{
            throw new BookingSaveException("An error has occurred. Could not save a new booking");
        });
    }

    @Override
    public Booking updateBooking(Booking booking) {

        return repository.findById(booking.getId()).map(oldBooking -> repository.save(booking).get()).orElseThrow(()-> {
            throw new BookingSaveException("An error has occurred. Could not update booking with id: " + booking.getId());
        });
    }

    @Override
    public Booking deleteBooking(String id) {

        return repository.findById(id).map(oldBooking -> {

            repository.delete(oldBooking);

            return oldBooking;

        }).orElseThrow(()-> {
            throw new BookingDeleteException("An error has occurred. Could not delete booking with id: " + id);
        });


    }
}
