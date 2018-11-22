package com.asgdrones.drones.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Register {

    //entity creation to map to column fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "hoursofflying")
    private int hoursOfFlying;

    @Column(name = "disability")
    private String disability;

    @Column(name = "englishspeakinglevel")
    private int englishLevel;

    @Column(name = "insured")
    private int insured;

    @Column(name = "paid")
    private int paid;

    @Column(name = "preferredGSLocation")
    private String preferredLocation;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    @JoinColumn(name = "drone_droneid")
    private Drone droneID;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    @JoinColumn(name = "course_courseid")
    private Course courseID;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_loginid")
    private Login LoginID;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name = "address_addressid")
    private Address address;




}

