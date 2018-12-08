package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.*;
import com.asgdrones.drones.services.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void customerProgressionDoesExistTest() throws Exception{
        List<Course> courseList = new ArrayList<>();
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"jbuckland","1234","customer");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2","Cardiff", java.sql.Date.valueOf(LocalDate.now()),instructor);
        courseList.add(course);
        when(courseService.getCourses()).thenReturn(courseList);
        this.mockMvc.perform(get("/customer/1/course_progression"))
                .andDo(print()).andExpect(status().isOk());
    }
    //todo
    @Test
    public void customerPageTest() throws Exception{
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Drone drone = new Drone(1L,"n/a","n/a");
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(2)));
        Login login = new Login(2L,"customer","jbuckland","password");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2","Cardiff", java.sql.Date.valueOf(LocalDate.now()),instructor);
        Customer customer = new Customer(2L, "James", "Buckland", java.sql.Date.valueOf("1998-11-16"),"jbuckland@gmail.com","01895430027",true,
                (float)2.0,"none",(float)9.0,"Cardiff",true,login,drone,address,course, creation);
        this.mockMvc.perform(get("/customer/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cardiff")));
    }
}
