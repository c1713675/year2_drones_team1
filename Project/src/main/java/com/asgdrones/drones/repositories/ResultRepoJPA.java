package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepoJPA extends JpaRepository<Result, Long>, ResultRepo {
    @Query(value = "SELECT COUNT(r.ResultID) FROM results r WHERE r.ResultID = 1", nativeQuery = true)
    Optional<Integer> countAllResults();
    Optional<Integer> countAllByPassfailIsTrue();
}
