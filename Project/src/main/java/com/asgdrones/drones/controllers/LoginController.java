package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import com.asgdrones.drones.services.LoginService;
import com.asgdrones.drones.services.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    private LoginRepoJPA loginRepoJPA;
    private LoginServiceInterface loginService;

    @Autowired
    LoginController(LoginRepoJPA LRepo, LoginServiceInterface LService) {
        loginRepoJPA = LRepo;
        loginService = LService;
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView getLogin(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return new ModelAndView("login", model.asMap());
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView postLogin(@Valid Login login,
                                  BindingResult bindingResult,
                                  HttpServletResponse response,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation error" + bindingResult.getFieldErrors());
        } else {
            String access = loginService.checkLogin(login);
            System.out.println("Form Received");
            System.out.println("access: "+access);
            System.out.println("username: "+login.getUsername());
            System.out.println("password: "+login.getPassword());
            response.addCookie(new Cookie("Access",access));
        }
        model.addAttribute("login", login);
        return new ModelAndView("landingPage", model.asMap());
    }
}
