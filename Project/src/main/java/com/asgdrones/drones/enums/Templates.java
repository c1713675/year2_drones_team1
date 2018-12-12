package com.asgdrones.drones.enums;

public enum Templates {

    INSTRUCTOR_ACCOUNT("instructorAccount"),
    CUSTOMER_ACCOUNT("customerAccount"),
    ADMIN_ACCOUNT("adminAccount"),
    CUSTOMER_FEEDBACK("feedback"),
    CUSTOMER_PROGRESSION("customerProgression"),
    ACCESS_DENIED("accessDenied"),
    CREATE_COURSE_DATE("createCourseDate"),
    COURSE_CREATED("courseCreated"),
    ADMIN_FEEDBACK("adminFeedbackAccount");

    private final String name;

    private Templates(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}
