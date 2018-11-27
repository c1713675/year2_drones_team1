package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.repositories.CustomerRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    private CustomerRepoJPA customerRepoJPA;

    @Override
    public List<Customer> findAllById(Iterable<Long> id) {
        return customerRepoJPA.findAllById(id);
    }
}
