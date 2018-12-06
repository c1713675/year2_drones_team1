package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepoJPA extends JpaRepository<Address,Long>, AddressRepo {
}
