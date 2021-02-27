package com.codeclan.example.course_booking.repositories;

import com.codeclan.example.course_booking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByRating(int rating);

    List<Course> findCoursesByBookingsCustomerName(String customerName);
}
