package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Instructor;
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
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepoJPA.getOne(instructorId);
    }

    @Override
    public List<String> getInstructorAddress(Long loginID) {
        List<String> addresses = instructorRepoJPA.getInstructorAddresses(loginID);
        return addresses;
    }

    @Override
    public Instructor getInstructorByUsername(String username) {
        List<Number> instructorIDList = instructorRepoJPA.findByUsername(username);
        Long instructorId = instructorIDList.get(0).longValue();
        return this.getInstructorById(instructorId);
    }

    @Override
    public List<Date> getCourseDates(Long loginID) {
        List<Date> dates = instructorRepoJPA.getCourseDates(loginID);
        return dates;
    }
}
