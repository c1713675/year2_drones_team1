package com.asgdrones.drones.services;


import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.repositories.AddressRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements AddressServiceInterface {
    private AddressRepoJPA addressRepoJPA;
    @Autowired
    AddressService(AddressRepoJPA aJPA){
        addressRepoJPA = aJPA;
    }

    @Override
    public void upload(Address address) {

    }
}
