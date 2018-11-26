package com.asgdrones.drones.services;

import java.util.Date;
import java.util.List;

public interface InstructorServiceInterface {
    public List<String> getInstructorAddress(Integer loginID);
    public Integer getInstructorIDByUsername(String username);
    public List<Date> getCourseDates(Integer loginID);
}
