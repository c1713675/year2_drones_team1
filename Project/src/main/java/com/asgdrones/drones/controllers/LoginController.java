package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
@RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView login(Model model){
    Login login = new Login();
    model.addAttribute("login", login);
    return new ModelAndView("login",model.asMap());
}
}
