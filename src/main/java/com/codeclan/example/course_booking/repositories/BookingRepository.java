package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
