package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.repositories.CourseRepoJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {
    private CourseRepoJPA courseRepoJPA;

    @Override
    public List<Course> findAllByInstructorID(Integer id) {
        return courseRepoJPA.findAllByInstructorID(id);
    }
}
