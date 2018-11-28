package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Instructor;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InstructorControllerTest {

    @Autowired
    private InstructorRepoJPA instructorRepoJPA;

    @Test
    public void instructorLocationTest() throws Exception {
        List<String> addresses = this.instructorRepoJPA.getInstructorAddresses(11L);

        assertEquals(addresses.get(0), "London");

    }

    @Test
    public void instructorDateTest(){
        List<Date> dates = this.instructorRepoJPA.getCourseDates(11L);

        assertEquals(dates.get(0).toString(),"2019-03-04");
    }
}
