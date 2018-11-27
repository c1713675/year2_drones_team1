package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Drone;
import com.asgdrones.drones.domain.Login;

public interface RegisterServiceInterface {
    public void upload(Address address, Drone drone, Customer customer, Login login);


}
