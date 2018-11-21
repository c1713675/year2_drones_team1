package com.asgdrones.drones;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import com.asgdrones.drones.services.LoginServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import java.util.Optional;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
//@DataJpaTest
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    LoginServiceInterface loginService;

   /* @Autowired
    private LoginRepoJPA loginRepoJPA;
    @Autowired
    private TestEntityManager entityManager;*/

    @Test
    public void adminLoginTest() throws Exception {
        Login adminLogin = new Login(null, "John", "password", null);
        given(this.loginService.checkLogin(adminLogin)).willReturn("admin");
        Cookie adminCookie = new Cookie("Access", "admin");
        mockMvc.perform(
                post("/login").param("username", "John").param("password", "password")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(cookie().exists("Access"))
                .andExpect(status().isOk())
                .andExpect(cookie().value("Access", "admin"));
    }

    @Test
    public void instructorLoginTest() throws Exception {
        Login instructorLogin = new Login(null, "Ins", "pass", null);
        given(this.loginService.checkLogin(instructorLogin)).willReturn("instructor");
        Cookie instructorCookie = new Cookie("Access", "instructor");
        mockMvc.perform(
                post("/login").param("username", "Ins").param("password", "pass")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(cookie().exists("Access"))
                .andExpect(status().isOk())
                .andExpect(cookie().value("Access", "instructor"));
    }

    @Test
    public void customerLoginTest() throws Exception {
        Login customerLogin = new Login(null, "Custom", "123", null);
        given(this.loginService.checkLogin(customerLogin)).willReturn("customer");
        Cookie customerCookie = new Cookie("Access", "customer");
        mockMvc.perform(
                post("/login").param("username", "Custom").param("password", "123")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(cookie().exists("Access"))
                .andExpect(status().isOk())
                .andExpect(cookie().value("Access", "customer"));
    }
}
