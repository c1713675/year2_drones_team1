package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Customer;

import java.util.List;

public interface CustomerRepo {


    public List<Customer> findBySearchTerm(String searchQuery);


}
