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

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Dob")
    private String dob;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "HoursOfFlying")
    private int hoursOfFlying;

    @Column(name = "Disability")
    private String disability;

    @Column(name = "EnglishSpeakingLevel")
    private String englishLevel;

    @Column(name = "Insured")
    private String insured;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID")
    private Address address;




}

