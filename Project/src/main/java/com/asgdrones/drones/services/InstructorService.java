package com.asgdrones.drones.services;

import com.asgdrones.drones.repositories.CourseRepoJPA;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService implements InstructorServiceInterface {
    private InstructorRepoJPA instructorRepoJPA;
    private CourseRepoJPA courseRepoJPA;

    @Autowired
    InstructorService(InstructorRepoJPA iRepo, CourseRepoJPA cRepo) {
        instructorRepoJPA = iRepo;
        courseRepoJPA = cRepo;
    }

    @Override
    public List<String> getInstructorAddress(Integer loginID) {
        List<String> addresses = instructorRepoJPA.getInstructorAddresses(loginID);
        return addresses;
    }

    @Override
    public Integer getInstructorIDByUsername(String username) {
        List<Integer> instructorIDList = instructorRepoJPA.findByUsername(username);
        Integer instructorID = instructorIDList.get(0);
        return instructorID;
    }

    @Override
    public List<Date> getCourseDates(Integer loginID) {
        List<Date> dates = instructorRepoJPA.getCourseDates(loginID);
        return dates;
    }
}
