package com.busticket.infra.configuration;

import com.busticket.BusTicketApplication;
import com.busticket.domain.entity.Booking;
import com.busticket.domain.repository.BookingRepository;
import com.busticket.domain.service.BookingService;
import com.busticket.domain.service.DomainBookingService;
import com.busticket.infra.converter.BookingConverter;
import com.busticket.infra.converter.EntityConverter;
import com.busticket.infra.entity.BookingM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BusTicketApplication.class)
public class BeanConfiguration {

    @Bean
    BookingService bookingService(final BookingRepository bookingRepository) {
        return new DomainBookingService(bookingRepository);
    }

    @Bean
    public EntityConverter<BookingM, Booking> bookingConverter() {
        return new BookingConverter();
    }
}