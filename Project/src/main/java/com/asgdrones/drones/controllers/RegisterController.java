package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Register;
import com.asgdrones.drones.repositories.RegisterRepo;
import com.asgdrones.drones.repositories.RegisterRepoJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private RegisterRepo registerRepo;

    @Autowired
    public RegisterController(RegisterRepo rRepo) {
        this.registerRepo = rRepo;
    }

    static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView addRegister(Model model) {
        Register register = new Register();
        model.addAttribute("register", register);
        return new ModelAndView("register", model.asMap());
    }


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView addRegisterForm(@Valid Register rregister, BindingResult bindingResult, Model model) {
        //binding result stops it from being null

        if (bindingResult.hasErrors()){
            System.out.println(bindingResult);
        }
        System.out.println("Form Received");
        System.out.println(rregister);
        model.addAttribute("firstName", rregister.getFirstName());
        model.addAttribute("lastName", rregister.getLastName());
        model.addAttribute("dob", rregister.getDob());
        model.addAttribute("email", rregister.getEmail());
        model.addAttribute("hoursOfFlying", rregister.getHoursOfFlying());
        model.addAttribute("disability", rregister.getDisability());
        model.addAttribute("insured", rregister.getInsured());
        model.addAttribute("address",rregister.getAddress());


        // call service to save charity
        // saving to db
        this.registerRepo.save(rregister);

        return new ModelAndView("AccountCreated", model.asMap());
    }


    }

}




