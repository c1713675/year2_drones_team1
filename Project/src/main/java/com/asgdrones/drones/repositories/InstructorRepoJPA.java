package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//This code needs changing - Currently this displays the instructor's city, when it is supposed to show their course location.
//The schema will need changing to solve this issue.
@Repository
public interface InstructorRepoJPA extends JpaRepository<Instructor,Long>,InstructorRepo {
    @Query(value = "SELECT a.City FROM instructor i JOIN address a ON i.address_AddressID = a.AddressID WHERE i.login_LoginID = :loginID", nativeQuery = true)
    List<String> getInstructorAddresses(@Param("loginID") Long loginID);
//
//    @Query(value = "SELECT loginID FROM Login WHERE Username = :un")
//    List<String> findByUsername(@Param("un") String un);
}
