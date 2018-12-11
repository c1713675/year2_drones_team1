package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;

import java.util.List;

public interface AdminServiceInterface {
    public String GetAdminPostCode(Long loginID);
    public String GetAdminCity(Long loginID);
    public String GetAdminStreet(Long loginID);
    public Integer GetAdminHouseNumber(Long loginID);
    public String GetAdminHouseName(Long loginID);

    public String getAdminName(Long adminId);
    public Admin getAdmin (Long loginID);

//    Feedback getFeedback(Long feedbackID);

    public List<Customer> getCustomers();
    public List<Customer> searchCustomers(String searchQuery);


//    public Integer GetAdminSatsifaction(Long FeedbackID);

//    Integer GetAdminSatisfaction(Long FeedbackID);
//
//    public Integer GetAdminDifficulty(Long FeedbackID);
//    public String GetAdminComments(Long FeedbackID);
}
