package com.asgdrones.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseid")
    private Long id;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "CourseType")
    private String courseType;

    @Column(name = "CourseLocation")
    private String courseLocation;

    @Column(name = "CourseDate")
    private Date courseDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "Instructor_InstructorID")
    private Instructor instructor;
}
