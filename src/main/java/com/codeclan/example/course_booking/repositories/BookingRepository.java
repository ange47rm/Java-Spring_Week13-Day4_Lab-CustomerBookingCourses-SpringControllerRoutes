package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsByDate (String date);
}
