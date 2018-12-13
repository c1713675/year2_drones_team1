package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;

public interface RegisterServiceInterface {
    public void upload(Address address, Drone drone, Customer customer, Login login, Feedback feedback);


}
