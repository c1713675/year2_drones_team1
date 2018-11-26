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
    @GeneratedValue
    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "CourseType")
    private String courseType;

    @Column(name = "CourseLocation")
    private String courseLocation;

    @Column(name = "CourseDate")
    private String courseDate;

    @Column(name = "Instructor_InstructorID")
    private Integer instructorID;
}
