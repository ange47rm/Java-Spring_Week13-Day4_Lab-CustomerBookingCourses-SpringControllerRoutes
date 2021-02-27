package com.codeclan.example.course_booking.controllers;

import com.codeclan.example.course_booking.models.Course;
import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam (name = "rating", required = false) Integer rating,
            @RequestParam (required = false) String customer
    ){
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        } else if (customer != null) {
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerName(customer), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }}

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourses(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity putCourse(@RequestBody Course course, @PathVariable Long id){

        Course courseToUpdate = courseRepository.findById(id).get(); // GET COURSE TO BE EDITED

        courseToUpdate.setName(course.getName()); // CHANGE COURSE NAME
        courseToUpdate.setTown(course.getTown()); // CHANGE COURSE TOWN
        courseToUpdate.setRating(course.getRating()); // CHANGE COURSE RATING
        courseRepository.save(courseToUpdate); // UPDATE CUSTOMER IN DB

        return new ResponseEntity(courseToUpdate, HttpStatus.OK); // RETURN UPDATED CUSTOMER OBJECT

    }
}
