package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ResultJPATest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ResultRepoJPA resultRepoJPA;

    @Test
    public void testCountAllResults(){
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(2)));
        Drone drone = new Drone(1L, "Manufacturer Test", "Model Test");
        Address address = new Address(null, "AB123CD", "Cardiff", "Test Lane", 7, null);
        Login login = new Login(null, "customer", "custom", "123");
        Instructor instructor = new Instructor(null, "Ins", "Tructor", "01234567890", login, address);
        Course course = new Course(null, "Course 1", "GS", "Cardiff", java.sql.Date.valueOf(LocalDate.now()), instructor);
        Customer customer = new Customer(null, "Test", "Customer", java.sql.Date.valueOf(LocalDate.now()), "test@gmail.com", "01234567890", true, (float) 10.0, "none", (float) 5.0, "Cardiff", true, false, login, drone, address, course, creation);
        Result result1 = new Result(null, 100, true, "GS", customer.getId());
//        Result result2 = new Result(null, 100, true, "GS", customer.getId());
//        Result result3 = new Result(null, 100, true, "GS", customer.getId());
        this.entityManager.merge(result1);
//        this.entityManager.merge(result2);
//        this.entityManager.merge(result3);
//        this.entityManager.persist(result1);
//        this.entityManager.persist(result2);
//        this.entityManager.persist(result3);
        Integer amountResults = this.resultRepoJPA.countAllResults().get();
        assertThat(amountResults).isEqualTo(1);
    }
}
