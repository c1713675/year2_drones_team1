package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateReferenceID", nullable = false)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dob")
    private LocalDate Dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "hoursofflying")
    private Float hoursOfFlying;

    @Column(name = "disability")
    private String disability;

    @Column(name = "englishspeakinglevel")
    private Float englishSpeakingLevel;

    @Column(name = "preferredGSLocation")
    private String preferredGSLocation;

    @Column(name = "insured")
    private Boolean insured;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_loginid")
    private Login login;




//      ******* add these later *********

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_droneid")
    private Drone drone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_addressid")
    private Address address;


//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_courseid")
    private Course course;







}
