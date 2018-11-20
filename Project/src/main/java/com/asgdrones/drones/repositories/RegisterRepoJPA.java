package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepoJPA extends JpaRepository<Register,Long> {}
