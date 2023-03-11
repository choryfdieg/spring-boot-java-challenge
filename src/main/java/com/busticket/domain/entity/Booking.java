package com.busticket.domain.entity;

import jakarta.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Booking {
    private String id;
    private String name;
    @Email
    private String email;
    private String origin;
    private String destination;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureDate;
    private String time;
    private Integer duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
