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
        @Column(name = "feedbackid")
        private Long id;

        @Column(name = "satisfaction")
        private int satisfaction;

        @Column(name = "difficulty")
        private int difficulty;

        @Column(name = "comments")
        private String comments;




}
