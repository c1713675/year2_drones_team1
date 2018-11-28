package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepoJPA extends JpaRepository<Course,Long>, CourseRepo {
}
