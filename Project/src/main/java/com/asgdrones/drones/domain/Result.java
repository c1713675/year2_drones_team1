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

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_CandidateReferenceID")
    private Customer candidateReferenceId;
}
