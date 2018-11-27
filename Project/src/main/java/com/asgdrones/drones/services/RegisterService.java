package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;
import com.asgdrones.drones.enums.Access;
import com.asgdrones.drones.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterServiceInterface {
    private CustomerRepoJPA customerRepoJPA;
    private LoginRepoJPA loginRepoJPA;
    private AddressRepoJPA addressRepoJPA;
    private DroneRepoJPA droneRepoJPA;

    @Autowired
    RegisterService(CustomerRepoJPA cRepo, LoginRepoJPA lRepo, AddressRepoJPA aRepo, DroneRepoJPA dRepo) {
        customerRepoJPA = cRepo;
        loginRepoJPA = lRepo;
        addressRepoJPA = aRepo;
        droneRepoJPA = dRepo;
    }

    @Override
    public void upload(Address address, Drone drone, Customer customer, Login login) {
        Course course = new Course(null,"","");
        Drone newDrone = new Drone(null, drone.getManufacturer(), drone.getModel());
        Login newLogin = new Login(null, "customer", login.getUsername(), login.getPassword());
        Customer newCustomer = new Customer(null, customer.getFirstName(),
                customer.getLastName(), customer.getDob(),
                customer.getEmail(), customer.getPhoneNumber(),
                customer.getPaid(), customer.getHoursOfFlying(),
                customer.getDisability(), customer.getEnglishSpeakingLevel(), customer.getPreferredGSLocation(),
                customer.getInsured(), newLogin, newDrone, address, course);
        customerRepoJPA.save(newCustomer);
        droneRepoJPA.save(newDrone);
        loginRepoJPA.save(newLogin);
        addressRepoJPA.save(address);

    }
}
