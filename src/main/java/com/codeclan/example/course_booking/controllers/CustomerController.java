package com.codeclan.example.course_booking.controllers;

import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.xml.ws.Response;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(required = false) Long courseID
    ){
        if (courseID != null){
            return new ResponseEntity<>(customerRepository.findAllByBookingsCourseId(courseID), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }}

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer (@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Long> deleteCustomer (@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity putCustomer (@RequestBody Customer customer, @PathVariable Long id){

        Customer customerToUpdate = customerRepository.findById(id).get();  // GET CUSTOMER OBJECT TO BE EDITED

        customerToUpdate.setName(customer.getName());       // CHANGE CUSTOMER NAME WITH PROVIDED NAME
        customerToUpdate.setTown(customer.getTown());       // CHANGE CUSTOMER TOWN WITH PROVIDED NAME
        customerToUpdate.setAge(customer.getAge());         // CHANGE CUSTOMER AGE WITH PROVIDED NAME
        customerRepository.save(customerToUpdate);                          // UPDATE CUSTOMER IN DATABASE

        return new ResponseEntity(customerToUpdate, HttpStatus.OK);         // RETURN UPDATED CUSTOMER OBJECT
    }
}
