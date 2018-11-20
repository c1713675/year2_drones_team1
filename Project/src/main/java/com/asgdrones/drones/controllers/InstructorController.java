package com.asgdrones.drones.controllers;

import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class InstructorController {
    private Cookie[] access;
    private Templates page;
    private InstructorRepoJPA instructorRepoJPA;

    @Autowired
    InstructorController(InstructorRepoJPA iRepo){
      instructorRepoJPA = iRepo;
    }
    @RequestMapping(value = "instructor", method = RequestMethod.GET)
    public ModelAndView instructor(Model model,
                                   HttpServletRequest request){
        access = request.getCookies();
        System.out.println(access[1].getName() +" " +access[1].getValue());
        if (access[1].getValue().equals("instructor")){
            page = Templates.INSTRUCTOR_ACCOUNT;
        }else {
            page = Templates.ACCESS_DENIED;
        }
        return new ModelAndView(page.toString(), model.asMap());
    }

}
