package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Result;

import java.util.List;

public interface ResultServiceInterface {
    Integer countAllResults(Long customerId);
    Integer countAllByPassfailIsTrue();
    List<Result> findAll();
}
