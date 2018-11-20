package com.asgdrones.drones;

import com.asgdrones.drones.controllers.RegisterController;
import com.asgdrones.drones.domain.Register;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsgDronesApplicationTests {


    @Autowired
    public RegisterController registerController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(registerController).isNotNull();
    }

}
