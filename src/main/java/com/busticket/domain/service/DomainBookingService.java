package com.busticket.domain.service;

import com.busticket.app.exception.BookingDeleteException;
import com.busticket.app.exception.BookingNotFoundException;
import com.busticket.app.exception.BookingSaveException;
import com.busticket.domain.constant.Message;
import com.busticket.domain.entity.Booking;
import com.busticket.domain.repository.BookingRepository;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class DomainBookingService implements BookingService{

    private final BookingRepository repository;

    public DomainBookingService(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking findBookingById(String id) {

        return repository.findById(id).map(booking -> {

            booking.setTime(new SimpleDateFormat("HH:mm:ss").format(booking.getDepartureDate()));

            return booking;

        }).orElseThrow(()->{
            throw new BookingNotFoundException(Message.NO_BOOKING_FOUND + id);
        });

    }

    @Override
    public List<Booking> findAllBookings() {

        return repository.findAll().stream().map(booking -> {

            booking.setTime(new SimpleDateFormat("HH:mm:ss").format(booking.getDepartureDate()));

            return booking;

        }).collect(Collectors.toList());
    }

    @Override
    public Booking createBooking(Booking booking) {

        return repository.save(booking).map(newBooking -> {

            newBooking.setTime(new SimpleDateFormat("HH:mm:ss").format(booking.getDepartureDate()));

            return newBooking;

        }).orElseThrow(()->{
            throw new BookingSaveException(Message.COULD_NOT_SAVE);
        });

    }

    @Override
    public void updateBooking(Booking booking) {

        repository.findById(booking.getId()).map(oldBooking -> repository.save(booking).get()).orElseThrow(()-> {
            throw new BookingSaveException(Message.COULD_NOT_UPDATE + booking.getId());
        });
    }

    @Override
    public void deleteBooking(String id) {

        repository.findById(id).map(oldBooking -> {

            repository.delete(oldBooking);

            return true;

        }).orElseThrow(()-> {
            throw new BookingDeleteException(Message.COULD_NOT_DELETE + id);
        });


    }
}
