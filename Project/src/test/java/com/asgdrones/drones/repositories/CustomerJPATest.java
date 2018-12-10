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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerJPATest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepoJPA customerRepoJPA;

    @Test
    public void customerJPATest() throws Exception{
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(2)));
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"customer","jbuckland","1234");
        Drone drone = new Drone(1L,"n/a","n/a");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2","Cardiff", java.sql.Date.valueOf(LocalDate.now()),instructor);
        this.entityManager.merge(new Customer(1L,"James","Buckland",
                new Date(16/11/1998),"j@gmail.com","01735432576",
                true,(float)13.0,"none",(float)5.0,"Cardiff",
                true, login,drone, address, course, creation));
        List<Customer> customerList = this.customerRepoJPA.findAll();
        assertThat(customerList.get(0).getFirstName()).isEqualTo("James");
        assertThat(customerList.get(0).getLastName()).isEqualTo("Buckland");
        assertThat(customerList.get(0).getDob()).isEqualTo(new Date(16/11/1998));
        assertThat(customerList.get(0).getEmail()).isEqualTo("j@gmail.com");
        assertThat(customerList.get(0).getPhoneNumber()).isEqualTo("01735432576");
        assertThat(customerList.get(0).getPaid()).isTrue();
        assertThat(customerList.get(0).getHoursOfFlying()).isEqualTo((float) 13.0);
        assertThat(customerList.get(0).getDisability()).isEqualTo("none");
        assertThat(customerList.get(0).getPreferredGSLocation()).isEqualTo("Cardiff");
        assertThat(customerList.get(0).getEnglishSpeakingLevel()).isEqualTo((float) 5.0);
        assertThat(customerList.get(0).getAddress().getPostcode()).isEqualTo("CF244AN");
        assertThat(customerList.get(0).getAddress().getCity()).isEqualTo("Cardiff");
        assertThat(customerList.get(0).getAddress().getHouseNumber()).isEqualTo(4);
        assertThat(customerList.get(0).getAddress().getHouseName()).isEqualTo("");
        assertThat(customerList.get(0).getAddress().getStreet()).isEqualTo("Abby Lane");
        assertThat(customerList.get(0).getLogin().getUsername()).isEqualTo("jbuckland");
        assertThat(customerList.get(0).getLogin().getPassword()).isEqualTo("1234");
        assertThat(customerList.get(0).getLogin().getAccess()).isEqualTo("customer");
    }
    @Test
    public void searchQueryTestByFirstName() throws Exception{
        Drone drone = new Drone(1L,"n/a","n/a");
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(2)));
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"customer","jbuckland","1234");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2","Cardiff", java.sql.Date.valueOf(LocalDate.now()),instructor);
        this.entityManager.merge(new Customer(2L,"Arron","Li",
                new Date(5/7/1992),"a@gmail.com","01643875987",
                true,(float)13.0,"none",(float)5.0,"Cardiff",
                true, login,drone,address,course, creation));
        List<Customer> customerList = this.customerRepoJPA.findBySearchTerm("Arron");
        assertThat(customerList.size()).isEqualTo(1);
    }
    @Test
    public void searchQueryTestByLastName() throws Exception{
        Drone drone = new Drone(1L,"n/a","n/a");
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(2)));
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"customer","jbuckland","1234");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2","Cardiff", java.sql.Date.valueOf(LocalDate.now()),instructor);
        this.entityManager.merge(new Customer(1L,"James","Buckland",
                new Date(16/11/1998),"j@gmail.com","01735432576",
                true,(float)13.0,"none",(float)5.0,"Cardiff",
                true, login,drone,address,course,creation));
        List<Customer> customerList = this.customerRepoJPA.findBySearchTerm("Buckland");
        assertThat(customerList.size()).isEqualTo(1);
    }

    @Test
    public void testGetFirstName(){
        Login login = new Login(1L, "instructor", "TestIns", "123");
        Address address = new Address(1L, "AB123CD", "Cardiff", "Abc Street", 1, null);
        Instructor instructor = new Instructor(1L, "Test", "TestLast", "01234567890", login, address);
        Course course = new Course(1L, "Name", "Type", "London", java.sql.Date.valueOf(LocalDate.now()), instructor);
        Drone drone = new Drone(1L, "N/A", "N/A");
        Creation creation = new Creation(null, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusYears(5)));
        this.entityManager.merge(new Customer(1L,"TestFirst","TestLast",
                new Date(01/01/1990),"test@gmail.com","01234567890",
                true,(float)7.0,"None",(float)5.0,"Cardiff",
                true, login,drone,address,course,creation));
        List<Customer> customers = this.customerRepoJPA.findByCourseId(course.getId());
        assertThat(customers.get(0).getFirstName()).isEqualTo("TestFirst");
    }
}
