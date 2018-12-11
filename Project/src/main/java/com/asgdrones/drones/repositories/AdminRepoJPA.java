package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Admin;
import com.asgdrones.drones.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepoJPA extends JpaRepository<Admin,Long>, AdminRepo {

    public Admin findAdminByLogin_Id(Long LoginID);
    public Address findByAddress_Id (Long addressID);
}
