package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.domain.Instructor;

import java.util.List;

public interface CourseServiceInterface {
    public List<Course> getCourses();
    List<Course> findByInstructor(Instructor instructor);
    void addCourse(Course course);
}
