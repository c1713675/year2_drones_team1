package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.domain.Instructor;
import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.repositories.CourseRepoJPA;
import com.asgdrones.drones.repositories.InstructorRepoJPA;
import com.asgdrones.drones.services.CourseService;
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
import java.util.Date;
import java.util.List;

@Controller
public class InstructorController {
    private Cookie[] access;
    private Templates page;
    private InstructorRepoJPA instructorRepoJPA;
    private InstructorService instructorService;
    private CourseService courseService;

    @Autowired
    InstructorController(InstructorRepoJPA iRepo, InstructorService iService, CourseService cService) {
        instructorRepoJPA = iRepo;
        instructorService = iService;
        courseService = cService;
    }

    @RequestMapping(value = "instructor/{instructorID}", method = RequestMethod.GET)
    public ModelAndView instructor(Model model,
                                   HttpServletRequest request,
                                   @PathVariable("instructorID") Long instructorID) {
        access = request.getCookies();
        for (Cookie obj : access) {
            if (obj.getName().equals("Access")) {
                if (obj.getValue().equals("instructor")) {
                    page = Templates.INSTRUCTOR_ACCOUNT;
                } else {
                    page = Templates.ACCESS_DENIED;
                }
            } else {
                page = Templates.ACCESS_DENIED;
            }
        }
        Instructor instructor = instructorService.getInstructor(instructorID);
        System.out.println(instructor);
        List<Course> courses = courseService.findByInstructor(instructor);
        List<String> addresses = instructorService.getInstructorAddress(instructor.getId());
        List<Date> dates = instructorService.getCourseDates(instructor.getId());
        System.out.println(courses);
        System.out.println(addresses);
        System.out.println(dates);
        model.addAttribute("addresses", addresses);
        model.addAttribute("dates", dates);
        model.addAttribute("courses", courses);
        return new ModelAndView(page.toString(), model.asMap());
    }

}
