package com.asgdrones.drones.enums;

public enum Templates {

    INSTRUCTOR_ACCOUNT("instructorAccount"),
    CUSTOMER_ACCOUNT("customerAccount"),
    ADMIN_ACCOUNT("adminAccount"),
    FEEDBACK("feedback"),
    CUSTOMER_PROGRESSION("customerProgression"),
    ACCESS_DENIED("accessDenied"),
    CREATE_COURSE_DATE("createCourseDate"),
    COURSE_CREATED("courseCreated"),
    INSTRUCTOR_CUSTOMER("instructorCustomer"),
    UPDATE_ADDRESS("updateAddress"),
    UPDATE_DRONE("updateDrone"),
    ADD_COURSE("addCourse"),
    DISPLAY_RESULTS("adminResults");

    private final String name;

    private Templates(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}
