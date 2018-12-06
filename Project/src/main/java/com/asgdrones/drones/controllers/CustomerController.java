package com.asgdrones.drones.controllers;

import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    private CustomerService customerService;
    private Cookie[] access;
    private Templates page;

    @Autowired
    CustomerController(CustomerService cService) {
        customerService = cService;
    }

    @RequestMapping(value = "customer/{customerUsername}", method = RequestMethod.GET)
    public ModelAndView customerPage(Model model,
                                     HttpServletRequest request,
                                     @PathVariable("customerUsername") String customerUsername) {
        access = request.getCookies();
        for (Cookie obj : access) {
            if (obj.getName().equals("Access")) {
                if (obj.getValue().equals("customer")) {
                    page = Templates.CUSTOMER_ACCOUNT;
                } else {
                    page = Templates.ACCESS_DENIED;
                }
            } else {
                page = Templates.ACCESS_DENIED;
            }
        }
        return new ModelAndView(page.toString(), model.asMap());
    }

    @RequestMapping(value = "customer/{customerID}/course_progression", method = RequestMethod.GET)
    public ModelAndView progressionPage(Model model,
                                        HttpServletRequest request,
                                        @PathVariable("customerID") Long customerID) {
        Integer progression = customerService.getCourseProgression(customerID);
        String name = customerService.getCustomerName(customerID);
        System.out.println(name);
        System.out.println(progression);
        String nameData[] = new String[]{name};
        Integer progressionData[] = new Integer[]{progression};
        page = Templates.CUSTOMER_PROGRESSION;
        model.addAttribute("name", nameData);
        model.addAttribute("progression", progressionData);
        return new ModelAndView(page.toString(), model.asMap());
    }
}
