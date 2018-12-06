package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Instructor;

import java.util.Date;
import java.util.List;

public interface InstructorServiceInterface {
//    public Instructor getInstructorById(Long instructorId);
    public List<String> getInstructorAddress(Long loginID);
//    public Instructor getInstructorByUsername(String username);
    public List<Date> getCourseDates(Long loginID);
    public Instructor getInstructor(Long id);
    public Instructor getInstructorById(Long id);
}
