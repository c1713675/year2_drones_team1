package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepoJPA extends JpaRepository<Customer,Long>, CustomerRepo {


}

