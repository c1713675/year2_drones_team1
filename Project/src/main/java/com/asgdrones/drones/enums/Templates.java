package com.asgdrones.drones.enums;

public enum Templates {

    INSTRUCTOR_ACCOUNT("instructorAccount"),
    CUSTOMER_ACCOUNT("customerAccount"),
    ADMIN_ACCOUNT("adminAccount"),
    FEEDBACK("feedback"),
    CUSTOMER_PROGRESSION("customerProgression"),
    ACCESS_DENIED("accessDenied");

    private final String name;

    private Templates(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}
