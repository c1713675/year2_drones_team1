package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    List<Customer> findAllById(Iterable<Long> id);
}
