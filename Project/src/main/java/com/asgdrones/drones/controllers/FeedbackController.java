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
public class FeedbackController {
    private Cookie[] access;
    private Templates page;

    @RequestMapping(value = "feedback/{feedback}", method = RequestMethod.GET)
    public ModelAndView feedback(Model model,
                                     HttpServletRequest request,
                                     @PathVariable("feedback") String feedback) {
        access = request.getCookies();
        if (access[0].getValue().equals("feedback")) {
            page = Templates.FEEDBACK;
        } else {
            page = Templates.ACCESS_DENIED;
        }
        return new ModelAndView(page.toString(), model.asMap());
    }
}
