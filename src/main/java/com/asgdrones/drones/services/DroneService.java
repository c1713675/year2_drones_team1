package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Drone;
import com.asgdrones.drones.repositories.AddressRepoJPA;
import com.asgdrones.drones.repositories.DroneRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class DroneService implements DroneServiceInterface {
    private DroneRepoJPA droneRepoJPA;
    @Autowired
    DroneService(DroneRepoJPA dJPA){
        droneRepoJPA = dJPA;
    }

    @Override
    public void upload(Drone drone) {

    }
}
