package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Admin;
import com.asgdrones.drones.domain.Customer;
import com.asgdrones.drones.domain.Login;

import java.util.List;

public interface AdminServiceInterface {
    public String GetAdminPostCode(Long loginID);
    public String GetAdminCity(Long loginID);
    public String GetAdminStreet(Long loginID);
    public Integer GetAdminHouseNumber(Long loginID);
    public String GetAdminHouseName(Long loginID);
    public String getAdminName(Long adminId);
    public Admin getAdmin (Long loginID);
    public List<Customer> getCustomers();
    public List<Customer> searchCustomers(String searchQuery);
}
