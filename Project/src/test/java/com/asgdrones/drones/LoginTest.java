package com.asgdrones.drones;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@DirtiesContext
@DataJpaTest
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LoginRepoJPA loginRepoJPA;
    @Autowired
    private TestEntityManager entityManager;

@Test
    public void adminLoginTest() throws Exception{
    //todo
}
}
