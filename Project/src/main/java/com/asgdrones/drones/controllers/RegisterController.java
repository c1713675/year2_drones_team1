package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.CustomerRepo;
import com.asgdrones.drones.repositories.CustomerRepoJPA;
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

    private CustomerRepo customerRepo;
    private CustomerRepoJPA customerRepoJPA;
    @Autowired
    public RegisterController(CustomerRepo cRepo, CustomerRepoJPA cReopJPA) {
        this.customerRepo = cRepo;
        this.customerRepoJPA = cReopJPA;
    }

    static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView addRegister(Model model) {
        Customer customer = new Customer();
        Login login = new Login();
        model.addAttribute("register", customer);
        return new ModelAndView("register", model.asMap());
    }


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView addRegisterForm(@Valid Customer rregister, BindingResult bindingResult, Model model) {
        //binding result stops it from being null

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
        }
        System.out.println("Form Received");
        System.out.println(rregister);
        model.addAttribute("firstName", rregister.getFirstName());
        model.addAttribute("lastName", rregister.getLastName());
        model.addAttribute("dob", rregister.getDob());
        model.addAttribute("email", rregister.getEmail());
        model.addAttribute("phoneNumber",rregister.getPhoneNumber());
        model.addAttribute("hoursOfFlying", rregister.getHoursOfFlying());
        model.addAttribute("disability", rregister.getDisability());
        model.addAttribute("englishSpeakingLevel",rregister.getEnglishSpeakingLevel());
        model.addAttribute("paid",rregister.getPaid());
        model.addAttribute("insured", rregister.getInsured());
        model.addAttribute("id", rregister.getId());
        model.addAttribute("preferredLocation",rregister.getPreferredGSLocation());
        model.addAttribute("login",rregister.getLogin());
        // call service to save charity
        // saving to db
        customerRepoJPA.save(rregister);

        return new ModelAndView("404", model.asMap());
    }


}
