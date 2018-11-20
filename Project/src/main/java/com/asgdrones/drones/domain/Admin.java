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
    @Column(name = "AdminID")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column (name = "LastName")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_LoginID")
    private Login login;

//    ***** add this later *****
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_AddressID")
//    private Address address;
}
