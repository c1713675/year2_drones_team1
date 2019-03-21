package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Admin;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.repositories.AdminRepoJPA;
import com.asgdrones.drones.repositories.CustomerRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AdminService implements AdminServiceInterface {
    private AdminRepoJPA adminRepoJPA;
    private CustomerRepoJPA customerRepoJPA;

    @Autowired
    AdminService(AdminRepoJPA aRepo, CustomerRepoJPA cRepo){
        adminRepoJPA = aRepo;
        customerRepoJPA = cRepo;
    }

    @Override
    public Admin getAdmin(Long loginID) {
        Admin admin = adminRepoJPA.findAdminByLogin_Id(loginID);
        return admin;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = customerRepoJPA.findAll();
        return customerList;
    }

    @Override
    public List<Customer> searchCustomers(String searchQuery) {
        List<Customer> customerList = customerRepoJPA.findBySearchTerm(searchQuery);
        return customerList;
    }

    @Override
    public String getAdminName(Long loginID){
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
            String adminFirstName = adminDetails.getFirstName();
            String adminLastName = adminDetails.getLastName();
            String FullName = adminFirstName +" "+ adminLastName;
            return FullName;
    }

    @Override
    public  String GetAdminPostCode(Long loginID){
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
        Address address = adminDetails.getAddress();
        if (address.getPostcode().isEmpty()){
            String postcode = "";
            return postcode;
        }else {
            String postCode = address.getPostcode();
            return postCode;
        }
    }

    @Override
    public String GetAdminCity(Long loginID) {
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
        Address address = adminDetails.getAddress();
        if (address.getCity().isEmpty()){
            String city = "";
            return city;
        }else {
            String city = address.getCity();
            return city;
        }
    }

    @Override
    public String GetAdminStreet(Long loginID) {
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
        Address address = adminDetails.getAddress();
        if (address.getStreet().isEmpty()){
            String street = "";
            return street;
        }else {
            String street = address.getCity();
            return street;
        }
    }

    @Override
    public Integer GetAdminHouseNumber(Long loginID) {
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
        Address address = adminDetails.getAddress();
            Integer houseNumber = address.getHouseNumber();
            return houseNumber;
    }

    @Override
    public String GetAdminHouseName(Long loginID) {
        Admin adminDetails =adminRepoJPA.findByLogin_Id(loginID);
        Address address = adminDetails.getAddress();
        if (address.getHouseName().isEmpty()){
            String houseName = "";
            return houseName;
        }else {
            String houseName = address.getHouseName();
            return houseName;
        }
    }
}
