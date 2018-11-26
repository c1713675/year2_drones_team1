package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Login;

public interface RegisterServiceInterface {
    public void upload(Address address, Customer customer, Login login);


}
