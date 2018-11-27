package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;

import java.util.List;

public interface CourseServiceInterface {
    List<Course> findAllByInstructorID(Integer id);
}
