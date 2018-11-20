package com.asgdrones.drones.services;

import com.asgdrones.drones.repositories.CustomerRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface {
    private CustomerRepoJPA customerRepoJPA;

    @Autowired
    CustomerService(CustomerRepoJPA cRepo){
        customerRepoJPA = cRepo;
    }
}
