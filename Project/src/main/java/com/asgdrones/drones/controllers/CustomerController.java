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
    CustomerController(CustomerService cService){
        customerService = cService;
    }
    @RequestMapping(value = "customer/{customerUsername}", method = RequestMethod.GET)
    public ModelAndView customerPage(Model model,
                                     HttpServletRequest request,
                                     @PathVariable("customerUsername") String customerUsername){
        access = request.getCookies();
        if (access[0].getValue().equals("customer")){
            page = Templates.CUSTOMER_ACCOUNT;
        }else {
            page = Templates.ACCESS_DENIED;
        }
        return new ModelAndView(page.toString(), model.asMap());
    }
}
