package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepoJPA extends JpaRepository<Login, Long>, LoginRepo {

    public List<Login> findByUsernameAndPassword(String username, String password);

    public Optional<Login> findByUsername(String username);

}
