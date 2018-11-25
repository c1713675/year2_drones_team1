package com.asgdrones.drones.services;

import java.util.Date;
import java.util.List;

public interface InstructorServiceInterface {
    public String getInstructorAddress(Integer loginID);
    public Integer getInstructorIDByUsername(String username);
    public Date getCourseDates(Integer loginID);
}
