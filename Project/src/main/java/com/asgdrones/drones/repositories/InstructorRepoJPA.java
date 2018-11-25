package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//This code needs changing - Currently this displays the instructor's city, when it is supposed to show their course location.
//The schema will need changing to solve this issue.
@Repository
public interface InstructorRepoJPA extends JpaRepository<Instructor,Long>,InstructorRepo {
    @Query(value = "SELECT c.CourseLocation FROM instructor i JOIN course c ON i.InstructorID = c.Instructor_InstructorID WHERE i.login_LoginID = :loginID", nativeQuery = true)
    List<String> getInstructorAddresses(@Param("loginID") Integer loginID);

    @Query(value = "SELECT loginID FROM Login WHERE Username = :un", nativeQuery = true)
    List<Integer> findByUsername(@Param("un") String un);

    @Query(value = "SELECT c.CourseDate FROM instructor i JOIN course c ON i.InstructorID = c.Instructor_InstructorID WHERE i.login_LoginID = :loginID", nativeQuery = true)
    List<Date> getCourseDates(@Param("loginID") Integer loginID);

}
