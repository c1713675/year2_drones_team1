package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long id;

    @Column(name = "mark")
    private int mark;

    @Column(name = "passfail")
    private boolean passfail;

    @Column(name = "typeoftest")
    private String typeOfTest;

    @Column(name = "customer_CandidateReferenceID")
    private Long candidateReferenceId;
}
