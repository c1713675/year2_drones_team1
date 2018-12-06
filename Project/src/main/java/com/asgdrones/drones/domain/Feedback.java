package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
 @Data
 @Entity
 @AllArgsConstructor
 @NoArgsConstructor
 @Table(name = "feedback")
 public class Feedback {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "FeedbackID")
        private Long id;

        @Column(name = "Satisfaction")
        private int satisfaction;

        @Column(name = "Difficulty")
        private int difficulty;

        @Column(name = "Comments")
        private String comments;




}
