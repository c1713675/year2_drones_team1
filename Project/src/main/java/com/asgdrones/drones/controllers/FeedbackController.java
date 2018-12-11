package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Admin;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Feedback;
import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.services.AdminService;
import com.asgdrones.drones.services.CustomerService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class FeedbackController {

    private Cookie[] access;
    private Templates page;
    private FeedbackService feedbackService;
    private AdminService adminService;
    private CustomerService customerService;

    @Autowired
    public FeedbackController(FeedbackService ffService, AdminService aService, CustomerService cService) {
        feedbackService = ffService;
        adminService = aService;
        customerService = cService;
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

    @RequestMapping(value = "/adminFeedbackAccount", method = RequestMethod.GET)
    public ModelAndView adminFeedbackAccount(Model model,
                                             HttpServletRequest request) {
        access = request.getCookies();
        for (Cookie obj : access) {
            if (obj.getName().equals("Access")) {
                if (obj.getValue().equals("admin")) {
                    page = Templates.ADMIN_FEEDBACK;
                    List<Customer> customerList = adminService.getCustomers();
                    Integer difficulty = adminService.GetAdminDifficulty(loginID);
                    model.addAttribute("customers",customerList);

//                    for(Customer c:customerList){
//                        c.getFirstName();
//                        c.getLastName();
//                        c.getFeedback().getDifficulty();
//                        c.getFeedback().getComments();
//                        c.getFeedback().getSatisfaction();
//
//                    }
                } else {
                    page = Templates.ACCESS_DENIED;
                }
            } else {
                page = Templates.ACCESS_DENIED;
            }
        }
        return new ModelAndView(page.toString(), model.asMap());
    }

}





