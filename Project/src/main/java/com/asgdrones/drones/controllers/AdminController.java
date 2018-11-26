package com.asgdrones.drones.controllers;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Admin;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.enums.Templates;
import com.asgdrones.drones.repositories.AdminRepoJPA;
import com.asgdrones.drones.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    private Cookie[] access;
    private Templates page;
    private AdminRepoJPA adminRepoJPA;
    private AdminService adminService;

    @Autowired
    AdminController(AdminRepoJPA aRepo, AdminService aService) {
        adminRepoJPA = aRepo;
        adminService = aService;
    }

    @RequestMapping(value = "admin/{loginID}", method = RequestMethod.GET)
    public ModelAndView adminAccount(Model model,
                                     HttpServletRequest request,
                                     @PathVariable("loginID") Long loginID) {
        access = request.getCookies();
        if (access[0].getValue().equals("admin")) {
            page = Templates.ADMIN_ACCOUNT;
            Admin adminDetails = adminService.getAdmin(loginID);
            String name = adminService.getAdminName(loginID);
            String postCode = adminService.GetAdminPostCode(loginID);
            String city = adminService.GetAdminCity(loginID);
            String street = adminService.GetAdminStreet(loginID);
            String houseNumber = adminService.GetAdminHouseNumber(loginID);
            List<Customer> customerList = adminService.getCustomers();
            System.out.println(Arrays.deepToString(new List[]{customerList}));
            String search = new String ();
            model.addAttribute("AdminName", name);
            model.addAttribute("postcode", postCode);
            model.addAttribute("city", city);
            model.addAttribute("street", street);
            model.addAttribute("houseNumber", houseNumber);
            model.addAttribute("customers", customerList);
            model.addAttribute("search",search);
        } else {
            page = Templates.ACCESS_DENIED;
        }
        return new ModelAndView(page.toString(), model.asMap());
    }

    @RequestMapping(value = "admin_search", method = RequestMethod.POST)
    public ModelAndView customerSearch(@RequestParam (value = "search", required = false)String searchQuery,
                                       Model model) {
        List<Customer> customerList = adminService.searchCustomers(searchQuery);
        System.out.println(searchQuery);
        System.out.println(Arrays.deepToString(new List[]{customerList}));
        model.addAttribute("customers", customerList);
        return new ModelAndView("customerSearch", model.asMap());
    }
}
