package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.*;

import java.util.List;

public interface CustomerServiceInterface {
    public Integer getCourseProgression(Long id);

    public String getCustomerName(Long id);


    public void updateFeedback(Long loginID, Feedback feedback);

}
