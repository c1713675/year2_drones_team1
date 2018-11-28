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
    @Column(name = "candidatereferenceID")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "Dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "hoursofflying")
    private Float hoursOfFlying;

    @Column(name = "disability")
    private Boolean disability;

    @Column(name = "englishspeakinglevel")
    private Float englishSpeakingLevel;

    @Column(name = "preferredGSLocation")
    private String preferredGSLocation;

    @Column(name = "insured")
    private Boolean insured;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_LoginID")
    private Login login;


//      ******* add these later *********
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "drone_DroneID")
//    private Drone drone;
//
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_AddressID")
    private Address address;
//
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_CourseID")
    private Course course;







}
