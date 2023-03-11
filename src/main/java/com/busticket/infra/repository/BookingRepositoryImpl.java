package com.busticket.infra.repository;

import com.busticket.domain.entity.Booking;
import com.busticket.domain.repository.BookingRepository;
import com.busticket.infra.converter.EntityConverter;
import com.busticket.infra.entity.BookingM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Primary
public class BookingRepositoryImpl implements BookingRepository {

    private final BookingMongoRepository repository;
    private final EntityConverter<BookingM, Booking> converter;

    @Autowired
    public BookingRepositoryImpl(BookingMongoRepository repository, EntityConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    public Optional<Booking> findById(String id) {
        return repository.findById(id).map(converter::entityToDomain);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll().stream().map(converter::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Booking> save(Booking booking) {

        BookingM bookingM = repository.save(converter.domainToEntity(booking));

        return Optional.of(converter.entityToDomain(bookingM));


    }
    @Override
    public void delete(Booking booking) {

        repository.deleteById(booking.getId());

    }
}
