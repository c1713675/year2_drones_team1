package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Admin;

import java.util.Optional;

public interface AdminRepo {
    public Admin findByLogin_Id(Long LoginID);
    public Address findByAddress_Id (Long addressID);
}
