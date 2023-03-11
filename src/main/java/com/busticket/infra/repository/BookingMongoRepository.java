package com.busticket.infra.repository;

import com.busticket.infra.entity.BookingM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<BookingM, String> {

}
