package com.asgdrones.drones.controllers;

import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import com.asgdrones.drones.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InstructorController {
    private Cookie[] access;
    private Templates page;
    private InstructorRepoJPA instructorRepoJPA;
    private InstructorService instructorService;

    @Autowired
    InstructorController(InstructorRepoJPA iRepo, InstructorService iService){
      instructorRepoJPA = iRepo;
      instructorService =  iService;
    }
    @RequestMapping(value = "instructor/{instructorUsername}", method = RequestMethod.GET)
    public ModelAndView instructor(Model model,
                                   HttpServletRequest request,
                                   @PathVariable("instructorUsername") String instructorUsername){
        access = request.getCookies();

        Integer instructorID = instructorService.getInstructorIDByUsername(instructorUsername);
        String address = instructorService.getInstructorAddress(instructorID);
        String date = instructorService.getCourseDates(instructorID);

        if (access[0].getValue().equals("instructor")){
            page = Templates.INSTRUCTOR_ACCOUNT;
        }else {
            page = Templates.ACCESS_DENIED;
        }
        model.addAttribute("addresses", address);
        model.addAttribute("dates", date);
        return new ModelAndView(page.toString(), model.asMap());
    }

}
