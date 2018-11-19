package com.asgdrones.drones.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Register {

    //entity creation to map to column fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "FirstNaame")
    private String Fname;

    @Column(name = "LastName")
    private String Lname;

    @Column(name = "Dob")
    private String dob;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(name = "HouseOfFlying")
    private Boolean hoursOfFlying;

    @Column(name = "Disability")
    private String disability;

    @Column(name = "EnglishSpeakingLevel")
    private String englishlevel;

    @Column(name = "Insured")
    private boolean insured;


    }

