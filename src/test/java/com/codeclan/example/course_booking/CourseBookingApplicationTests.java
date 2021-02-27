package com.codeclan.example.course_booking;

import com.codeclan.example.course_booking.models.Customer;
import com.codeclan.example.course_booking.repositories.CourseRepository;
import com.codeclan.example.course_booking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating(){
		assertEquals("Basic Ninja Skills", courseRepository.findCoursesByRating(5).get(0).getName());
	}

	@Test
	public void canFindAllCustomersByCourse(){
		assertEquals("Angelo", customerRepository.findAllByBookingsCourseId(3L).get(0).getName());
	}

	@Test
	public void canFindCoursesForGivenCustomer(){
		assertEquals(2, courseRepository.findCoursesByBookingsCustomerName("Angelo").size());
	}



}
