package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.repositories.CourseRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface{
    private CourseRepoJPA courseRepoJPA;

    @Autowired
    CourseService(CourseRepoJPA cRepo){
        courseRepoJPA = cRepo;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = courseRepoJPA.findAll();
        return courseList;
    }
}
