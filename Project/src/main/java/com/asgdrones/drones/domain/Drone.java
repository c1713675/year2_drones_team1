package com.asgdrones.drones.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "Drone")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "droneid")
    private Long id;

}