package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByBookingsCourseId(Long id);
}
