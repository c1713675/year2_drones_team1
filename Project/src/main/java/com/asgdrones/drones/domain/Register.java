package com.asgdrones.drones.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Register {

    //entity creation to map to column fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "preferredgslocation")
    private int preferredLocation;

    @Column(name = "Login_LoginID", nullable = true)
    private int loginid;

    @Column(name = "drone_DroneID", nullable = true)
    private int droneid;

    @Column(name = "course_courseID", nullable = true)
    private int courseid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name = "address_addressid")
    private Address address;




}

