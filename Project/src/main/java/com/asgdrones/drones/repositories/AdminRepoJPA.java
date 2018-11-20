package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepoJPA extends JpaRepository<Admin,Long>, AdminRepo {
}
