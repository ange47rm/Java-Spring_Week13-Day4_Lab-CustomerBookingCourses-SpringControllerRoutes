package com.codeclan.example.course_booking.components;

import com.apple.eawt.Application;
import com.codeclan.example.course_booking.CourseBookingApplication;
import com.codeclan.example.course_booking.models.Booking;
import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.BookingRepository;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){
    }
    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Steve", "Stirling", 34);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Mary", "Milan", 70);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Angelo", "Rome", 29);
        customerRepository.save(customer3);

        Course course1 = new Course ("Learn Spring", "Edinburgh", 3);
        courseRepository.save(course1);
        Course course2 = new Course ("Learn Knitting", "Glasgow", 4);
        courseRepository.save(course2);
        Course course3 = new Course ("Basic Ninja Skills", "Kyoto", 5);
        courseRepository.save(course3);

        Booking booking1 = new Booking("05-11-21", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("14-02-21", customer2, course2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("08-05-21", customer3, course3);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("05-11-21", customer3, course2);
        bookingRepository.save(booking4);

    }

}
