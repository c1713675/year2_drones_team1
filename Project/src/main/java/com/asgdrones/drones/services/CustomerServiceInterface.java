package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    public Integer getCourseProgression(Long id);
    public String getCustomerName(Long id);
    List<Customer> findAllById(Iterable<Long> id);
    List<Customer> findByCourseId(Long id);
}
