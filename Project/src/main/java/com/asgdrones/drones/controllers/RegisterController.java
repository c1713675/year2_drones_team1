package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Register;
import com.asgdrones.drones.repositories.RegisterRepo;
import com.asgdrones.drones.repositories.RegisterRepoJPA;
import com.asgdrones.drones.services.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    private RegisterService registerService;
    private RegisterRepoJPA registerRepoJPA;

    @Autowired
    public RegisterController(RegisterRepoJPA RRepo, RegisterService RService) {
        registerRepoJPA = RRepo;
        registerService = RService;
    }

    static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public ModelAndView getRegister(Model model) {
        Register register = new Register();
        model.addAttribute("register", register);
        return new ModelAndView("register", model.asMap());
    }

}




