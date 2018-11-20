package com.asgdrones.drones.controllers;

import com.asgdrones.drones.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    private CustomerService customerService;
    private Cookie[] access;
    private String page;
    @Autowired
    CustomerController(CustomerService cService){
        customerService = cService;
    }
    @RequestMapping(value = "customer", method = RequestMethod.GET)
    public ModelAndView customerPage(Model model,
                                     HttpServletRequest request){
        access = request.getCookies();
        System.out.println(access[1].getName() +" " +access[1].getValue());
        if (access[1].getValue().equals("customer")){
            page = "customerAccount";
        }else {
            page = "accessDenied";
        }
        return new ModelAndView(page, model.asMap());
    }
}
