package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Creation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationRepoJPA extends JpaRepository<Creation,Long>, CreationRepo {

}
