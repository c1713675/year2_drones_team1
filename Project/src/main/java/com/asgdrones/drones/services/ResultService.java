package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Result;
import com.asgdrones.drones.repositories.ResultRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService implements ResultServiceInterface{
    private ResultRepoJPA resultRepoJPA;

    @Autowired
    ResultService(ResultRepoJPA rRepo){
        resultRepoJPA = rRepo;
    }

    @Override
    public Integer countAllResults(Long customerId) {
        return resultRepoJPA.countAllResults(customerId).get();
    }

    @Override
    public Integer countAllByPassfailIsTrue() {
        return resultRepoJPA.countAllByPassfailIsTrue().get();
    }

    @Override
    public List<Result> findAll() {
        return resultRepoJPA.findAll();
    }
}
