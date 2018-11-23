package com.asgdrones.drones.services;

import com.asgdrones.drones.repositories.InstructorRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements InstructorServiceInterface {
    private InstructorRepoJPA instructorRepoJPA;

    @Autowired
    InstructorService(InstructorRepoJPA iRepo) {
        instructorRepoJPA = iRepo;
    }

    @Override
    public List<String> getInstructorAddresses(Long loginID) {
        return instructorRepoJPA.getInstructorAddresses(loginID);
    }
}
