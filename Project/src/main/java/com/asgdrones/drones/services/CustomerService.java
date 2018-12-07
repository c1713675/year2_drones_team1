package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.enums.Courses;
import com.asgdrones.drones.repositories.CourseRepoJPA;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.repositories.CustomerRepo;
import com.asgdrones.drones.repositories.CustomerRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    private CustomerRepoJPA customerRepoJPA;
    private int progression;

    @Autowired
    CustomerService(CustomerRepoJPA cRepo) {
        customerRepoJPA = cRepo;
    }



    @Override
    public List<Customer> findAllById(Iterable<Long> id) {
        return customerRepoJPA.findAllById(id);
    }

    @Override
    public Integer getCourseProgression(Long id) {
        Optional<Customer> customer = customerRepoJPA.findById(id);
        if (customer.isPresent()) {
            String courseName = customer.get().getCourse().getCourseName();
            System.out.println(courseName);
            if (courseName.equals(String.valueOf(Courses.COURSE_1))) {
                progression = 1;
            } else if (courseName.equals(String.valueOf(Courses.COURSE_2))) {
                progression = 2;
            } else if (courseName.equals(String.valueOf(Courses.COURSE_3))) {
                progression = 3;
            } else {
                progression = 0;
            }
        } else {
            progression = 0;
        }
        return progression;
    }

    @Override
    public String getCustomerName(Long id) {
        Optional<Customer> customer = customerRepoJPA.findById(id);
        if (customer.isPresent()) {
            String fullName = customer.get().getFirstName() + " " + customer.get().getLastName();
            return fullName;
        }
        return null;
    }



}
