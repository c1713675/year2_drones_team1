package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Feedback;
import com.asgdrones.drones.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepoJPA extends JpaRepository<Feedback,Long>,FeedbackRepo {
}
