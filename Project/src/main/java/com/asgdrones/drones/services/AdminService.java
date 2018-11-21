package com.asgdrones.drones.services;

import com.asgdrones.drones.repositories.AdminRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService implements AdminServicInterface {
    private AdminRepoJPA adminRepoJPA;

    @Autowired
    AdminService(AdminRepoJPA aRepo){
        adminRepoJPA = aRepo;
    }
}
