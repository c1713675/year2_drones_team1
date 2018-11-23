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
    public String getInstructorAddress(Integer loginID) {
        List<String> addresses = instructorRepoJPA.getInstructorAddresses(loginID);
        String address = addresses.get(0);
        return address;
    }

    @Override
    public Integer getInstructorIDByUsername(String username) {
        List<Integer> instructorIDList = instructorRepoJPA.findByUsername(username);
        Integer instructorID = instructorIDList.get(0);
        return instructorID;
    }
}
