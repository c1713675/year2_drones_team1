package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.*;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InstructorControllerTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private InstructorRepoJPA instructorRepoJPA;

    @Test
    public void instructorLocationTest() throws Exception {
        Login login = new Login(1L, "instructor", "TestIns", "123");
        Address address = new Address(1L, "AB123CD", "Cardiff", "Abc Street", 1, null);
//        Instructor instructor = new Instructor(1L, "Test", "TestLast", "01234567890", login, address);
        Course course = new Course(1L, "Name", "Type", "London", java.sql.Date.valueOf(LocalDate.now()), instructor);
        Drone drone = new Drone(1L, "N/A", "N/A");
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(5)));
        this.entityManager.merge(new Instructor(1L, "Ins", "Tructor", "01234567890", login, address));
        Optional<Instructor> instructor = this.instructorRepoJPA.findById(1L);
//        assertEquals();
    }

    @Test
    public void instructorDateTest(){
        List<Date> dates = this.instructorRepoJPA.getCourseDates(11L);
        assertEquals(dates.get(0).toString(),"2019-03-04");
    }
}
