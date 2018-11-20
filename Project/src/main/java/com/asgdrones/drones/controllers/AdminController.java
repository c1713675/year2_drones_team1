package com.asgdrones.drones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    private Cookie[] access;
    private String page;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView adminAccount(Model model,
                                     HttpServletRequest request) {
        access = request.getCookies();
        if (access[1].getValue().equals("admin")) {
            page = "adminAccount";
        } else {
            page = "accessDenied";
        }
        return new ModelAndView(page, model.asMap());
    }
}
