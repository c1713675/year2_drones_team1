package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LoginJPATest {


    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private LoginRepoJPA repository;

    @Test
    public void loginTest() throws Exception{
        this.entityManager.merge(new Login(1L,"John","password","admin"));
        List<Login> login = this.repository.findByUsernameAndPassword("John","password");
        assertThat(login.get(0).getUsername()).isEqualTo("John");
        assertThat(login.get(0).getPassword()).isEqualTo("password");
        assertThat(login.get(0).getAccess()).isEqualTo("admin");
    }
}
