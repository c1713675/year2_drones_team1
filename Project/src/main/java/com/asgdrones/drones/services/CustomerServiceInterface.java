package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;

import java.sql.Date;
import java.util.List;

public interface CustomerServiceInterface {

    public Integer getCourseProgression(Long id);

    public String getCustomerName(Long id);


    public java.util.Date getDob(Long id);

    public Course getCourse(Long id);

    public String getDroneManufacturer(Long id);

    public String getDroneModel(Long id);

    public String getCustomerPostCode(Long loginID);

    public String getCustomerCity(Long loginID);

    public String getCustomerStreet(Long loginID);

    public Integer getCustomerHouseNumber(Long loginID);

    public String GetCustomerHouseName(Long loginID);

    List<Customer> findAllById(Iterable<Long> id);
    
    List<Customer> findByCourseId(Long id);

    public Boolean getVerified(Long loginID);

    public void updateAddress(Long loginID, Address address);

    public void updateDrone(Long loginID, Drone drone);

    public void addCourse(Long loginID, Long courseID);

    public void updateCustomer(Long loginID);

    public void updateFeedback(Long loginID, Feedback feedback);
}
