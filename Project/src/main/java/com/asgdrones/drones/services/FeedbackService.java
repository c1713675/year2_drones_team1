package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Feedback;
import com.asgdrones.drones.repositories.FeedbackRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements FeedbackServiceInterface{
    private FeedbackRepoJPA feedbackRepoJPA;

    @Autowired
    FeedbackService(FeedbackRepoJPA fRepo){
        feedbackRepoJPA = fRepo;
    }


    @Override
    public void upload(Feedback feedback) {
    }

}
