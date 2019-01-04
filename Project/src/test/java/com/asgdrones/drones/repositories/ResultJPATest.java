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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
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
        Result result1 = new Result(null, 100, true, "GS", customer);
        this.entityManager.merge(result1);
        Integer amountResults = this.resultRepoJPA.countAllResults().get();
        List<Result> resultList = resultRepoJPA.findAll();
//      Assertion to test that the amount of results found from the count JPA query is the same as the amount of results in a list found using JPA's findAll().
        assertThat(amountResults).isEqualTo(resultList.size());
    }
}
