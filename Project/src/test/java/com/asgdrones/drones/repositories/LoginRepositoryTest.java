package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.login.customer.LoginJPA;
import com.asgdrones.drones.repositories.login.customer.LoginRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase
public class LoginRepositoryTest {
    @Autowired
    private LoginJPA loginJPA;

    @Test
    public void findByLoginDetails(){
        Login login = this.loginJPA.findByLoginDetails("Test", "123");
        assertThat(login.getUsername()).isEqualTo("Test");
        assertThat(login.getId()).isEqualTo(1);
    }
}
