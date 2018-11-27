package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.domain.Instructor;

import java.util.List;

public interface CourseServiceInterface {
    List<Course> findByInstructor(Instructor instructor);
}
