package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Instructor;
import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.CourseRepoJPA;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService implements InstructorServiceInterface {
    private InstructorRepoJPA instructorRepoJPA;
    private CourseRepoJPA courseRepoJPA;
    private LoginRepoJPA loginRepoJPA;

    @Autowired
    InstructorService(InstructorRepoJPA iRepo, CourseRepoJPA cRepo, LoginRepoJPA aLoginRepo) {
        instructorRepoJPA = iRepo;
        courseRepoJPA = cRepo;
        loginRepoJPA=aLoginRepo;
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
        Optional<Login> theLogin = loginRepoJPA.findByUsername(username);
        Optional<Instructor> theInstructor = instructorRepoJPA.findByLogin(theLogin.get());
        return theInstructor.get();
    }

    @Override
    public List<Date> getCourseDates(Long loginID) {
        List<Date> dates = instructorRepoJPA.getCourseDates(loginID);
        return dates;
    }
}
