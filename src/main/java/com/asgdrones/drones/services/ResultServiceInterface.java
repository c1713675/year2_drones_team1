package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Result;

import java.util.List;

public interface ResultServiceInterface {
    Integer countAllResults();
    Integer countAllByPassfailIsTrue();
    List<Result> findAll();
}
