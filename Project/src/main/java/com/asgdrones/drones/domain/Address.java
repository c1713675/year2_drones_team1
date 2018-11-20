package com.asgdrones.drones.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "PostCode")
    private String postcode;

    @Column(name = "City")
    private String city;

    @Column(name = "Street")
    private String street;

    @Column(name ="HouseNumber")
    private int  houseNumber;

    @Column(name = "HouseName")
    private String houseName;




}
