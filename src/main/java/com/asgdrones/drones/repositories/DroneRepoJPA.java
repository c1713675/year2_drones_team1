package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Drone;
import org.springframework.data.repository.Repository;

public interface DroneRepoJPA extends Repository<Drone,Long>, DroneRepo {
}
