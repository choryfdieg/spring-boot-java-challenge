package com.busticket.infra.converter;

import com.busticket.domain.entity.Booking;
import com.busticket.infra.entity.BookingM;

public class BookingConverter implements EntityConverter<BookingM, Booking>{
    @Override
    public Booking entityToDomain(BookingM entity) {

        Booking domain =  new Booking();

        domain.setId(entity.getId());
        domain.setDestination(entity.getDestination());
        domain.setName(entity.getName());
        domain.setDuration(entity.getDuration());
        domain.setEmail(entity.getEmail());
        domain.setDepartureDate(entity.getDepartureDate());
        domain.setTime(entity.getTime());
        domain.setOrigin(entity.getOrigin());

        return domain;

    }

    @Override
    public BookingM domainToEntity(Booking domain) {

        BookingM entity = new BookingM();

        entity.setId(domain.getId());
        entity.setDestination(domain.getDestination());
        entity.setName(domain.getName());
        entity.setDuration(domain.getDuration());
        entity.setEmail(domain.getEmail());
        entity.setDepartureDate(domain.getDepartureDate());
        entity.setTime(domain.getTime());
        entity.setOrigin(domain.getOrigin());

        return entity;
    }
}