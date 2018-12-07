package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Feedback;
import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.services.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService fService) {
        feedbackService = fService;
    }

    static final Logger LOG = LoggerFactory.getLogger(Feedback.class);

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ModelAndView addFeedback(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return new ModelAndView("feedback", model.asMap());
    }

    @RequestMapping(path = "/feedback", method = RequestMethod.POST)
    public ModelAndView addLoginForm(@Valid Feedback feedback, BindingResult bindingResult, Model model) {
        //binding result stops it from being null
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
        }
        System.out.println(feedback);
        model.addAttribute("feedback", feedback);
        model.addAttribute("satisfaction", feedback.getSatisfaction());
        model.addAttribute("difficulty", feedback.getDifficulty());
        model.addAttribute("comments", feedback.getComments());
        feedbackService.save(feedback);

        return new ModelAndView("feedbacksubmit",model.asMap());
    }
}


