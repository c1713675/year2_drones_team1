package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateReferenceID")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Dob")
    private Date dob;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Paid")
    private Boolean paid;

    @Column(name = "HoursOfFlying")
    private Float hoursOfFlying;

    @Column(name = "Disability")
    private Boolean disability;

    @Column(name = "EnglishSpeakingLevel")
    private Float englishSpeakingLevel;

    @Column(name = "PreferredGSLocation")
    private String preferredGSLocation;

    @Column(name = "Insured")
    private Boolean insured;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_LoginID")
    private Login login;


//      ******* add these later *********
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "drone_DroneID")
//    private Drone drone;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_AddressID")
//    private Address address;
//
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_CourseID")
    private Course course;







}
