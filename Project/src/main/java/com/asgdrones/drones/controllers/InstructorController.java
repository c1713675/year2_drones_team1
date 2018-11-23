package com.asgdrones.drones.controllers;

import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
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

    @Autowired
    InstructorController(InstructorRepoJPA iRepo){
      instructorRepoJPA = iRepo;
    }
    @RequestMapping(value = "instructor/{instructorID}", method = RequestMethod.GET)
    public ModelAndView instructor(Model model,
                                   HttpServletRequest request,
                                   @PathVariable("instructorID") Long instructorID){
        access = request.getCookies();
//        todo
//        Currently having an issue with the ID being retrieved.
//        This issue is being caused by the findByUsername method returning a list of longs as opposed to one Long.
//        I need to change this so only one Long is returned.
//        List<Long> instructorID = instructorRepoJPA.findByUsername(instructorName);
        List<String> addresses = instructorRepoJPA.getInstructorAddresses(instructorID);
        if (access[0].getValue().equals("instructor")){
            page = Templates.INSTRUCTOR_ACCOUNT;
        }else {
            page = Templates.ACCESS_DENIED;
        }
        model.addAttribute("addresses", addresses);
        return new ModelAndView(page.toString(), model.asMap());
    }

}
