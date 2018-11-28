package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private Long id;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "coursetype")
    private String CourseType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_instructorID")
    private Instructor instructor;
}
