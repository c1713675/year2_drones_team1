package com.asgdrones.drones.services;

import com.asgdrones.drones.repositories.ResultRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements ResultServiceInterface{
    private ResultRepoJPA resultRepoJPA;

    @Autowired
    ResultService(ResultRepoJPA rRepo){
        resultRepoJPA = rRepo;
    }

    @Override
    public Integer countAllResults() {
        return resultRepoJPA.countAllResults();
    }

    @Override
    public Integer countAllByPassfailIsTrue() {
        return resultRepoJPA.countAllByPassfailIsTrue();
    }
}
