package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrator")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminid")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column (name = "lastname")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_loginid")
    private Login login;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_addressID")
    private Address address;
}
