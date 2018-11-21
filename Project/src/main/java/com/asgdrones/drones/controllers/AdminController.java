package com.asgdrones.drones.controllers;

import com.asgdrones.drones.enums.Templates;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    private Cookie[] access;
    private Templates page;

    @RequestMapping(value = "admin/{adminUsername}", method = RequestMethod.GET)
    public ModelAndView adminAccount(Model model,
                                     HttpServletRequest request,
                                     @PathVariable("adminUsername") String adminUsername) {
        access = request.getCookies();
        if (access[0].getValue().equals("admin")) {
            page = Templates.ADMIN_ACCOUNT;
        } else {
            page = Templates.ACCESS_DENIED;
        }
        return new ModelAndView(page.toString(), model.asMap());
    }
}