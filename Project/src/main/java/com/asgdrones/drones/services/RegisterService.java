package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;
import com.asgdrones.drones.enums.Access;
import com.asgdrones.drones.repositories.AddressRepoJPA;
import com.asgdrones.drones.repositories.CustomerRepo;
import com.asgdrones.drones.repositories.CustomerRepoJPA;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterServiceInterface {
    private CustomerRepoJPA customerRepoJPA;
    private LoginRepoJPA loginRepoJPA;
    private AddressRepoJPA addressRepoJPA;

    @Autowired
    RegisterService(CustomerRepoJPA cRepo, LoginRepoJPA lRepo, AddressRepoJPA aRepo) {
        customerRepoJPA = cRepo;
        loginRepoJPA = lRepo;
        addressRepoJPA = aRepo;
    }

    @Override
    public void upload(Address address, Customer customer, Login login) {
        Course course = new Course(null,"","");
        Drone drone = new Drone(null,"asg","redDrone");
        Login newLogin = new Login(null, "customer", login.getUsername(), login.getPassword());
        Customer newCustomer = new Customer(null, customer.getFirstName(),
                customer.getLastName(), customer.getDob(),
                customer.getEmail(), customer.getPhoneNumber(),
                customer.getPaid(), customer.getHoursOfFlying(),
                customer.getDisability(), customer.getEnglishSpeakingLevel(), customer.getPreferredGSLocation(),
                customer.getInsured(), newLogin, drone, address, course);
        customerRepoJPA.save(newCustomer);
        loginRepoJPA.save(newLogin);
        addressRepoJPA.save(address);

    }
}
