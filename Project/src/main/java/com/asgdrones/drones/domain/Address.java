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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressid")
    private Long id;

    @Column(name= "postcode")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name ="housenumber")
    private int  houseNumber;

    @Column(name = "housename")
    private String houseName;



}
