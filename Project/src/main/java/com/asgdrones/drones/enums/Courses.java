package com.asgdrones.drones.enums;

public enum Courses {

    COURSE_1("Course1"),
    COURSE_2("Course2"),
    COURSE_3("Course3");

    private final String name;

    private Courses(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
