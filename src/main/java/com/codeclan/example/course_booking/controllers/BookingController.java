package com.codeclan.example.course_booking.controllers;

import com.codeclan.example.course_booking.models.Booking;
import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity <List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id ) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity(booking, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id) {
        Optional<Booking> bookingToDelete = bookingRepository.findById(id);
        if (!bookingToDelete.isPresent()) {
            return new ResponseEntity(id, HttpStatus.NOT_FOUND);
        } else {
            bookingRepository.delete(bookingToDelete.get());
            return new ResponseEntity(id, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity putBooking (@RequestBody Booking booking, @PathVariable Long id){
        Booking bookingToUpdate = bookingRepository.findById(id).get();

        bookingToUpdate.setCourse(booking.getCourse());
        bookingToUpdate.setCustomer(booking.getCustomer());
        bookingToUpdate.setDate(booking.getDate());
        bookingRepository.save(bookingToUpdate);

        return new ResponseEntity(bookingToUpdate, HttpStatus.OK);
    }


}
