package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

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
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"jbuckland","1234","customer");
        this.entityManager.merge(new Customer(1L,"James","Buckland",
                new Date(16/11/1998),"j@gmail.com","01735432576",
                true,(float)13.0,false,(float)5.0,"Cardiff",
                true, login, address));
        List<Customer> customerList = this.customerRepoJPA.findAll();
        assertThat(customerList.get(0).getFirstName()).isEqualTo("James");
        assertThat(customerList.get(0).getLastName()).isEqualTo("Buckland");
        assertThat(customerList.get(0).getDob()).isEqualTo(new Date(16/11/1998));
        assertThat(customerList.get(0).getEmail()).isEqualTo("j@gmail.com");
        assertThat(customerList.get(0).getPhoneNumber()).isEqualTo("01735432576");
        assertThat(customerList.get(0).getPaid()).isTrue();
        assertThat(customerList.get(0).getHoursOfFlying()).isEqualTo((float) 13.0);
        assertThat(customerList.get(0).getDisability()).isFalse();
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
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"jbuckland","1234","customer");
        this.entityManager.merge(new Customer(2L,"Arron","Li",
                new Date(5/7/1992),"a@gmail.com","01643875987",
                true,(float)13.0,true,(float)5.0,"Cardiff",
                true, login, address));
        List<Customer> customerList = this.customerRepoJPA.findBySearchTerm("James");
        assertThat(customerList.size()).isEqualTo(1);
    }
    @Test
    public void searchQueryTestByLastName() throws Exception{
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"jbuckland","1234","customer");
        this.entityManager.merge(new Customer(1L,"James","Buckland",
                new Date(16/11/1998),"j@gmail.com","01735432576",
                true,(float)13.0,false,(float)5.0,"Cardiff",
                true, login, address));
        List<Customer> customerList = this.customerRepoJPA.findBySearchTerm("Buckland");
        assertThat(customerList.size()).isEqualTo(1);
    }
}
