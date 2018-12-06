package com.asgdrones.drones.enums;

public enum Access {

   ACCESS_ADMIN("admin"),
    ACCESS_INSTRUCTOR("instructor"),
    ACCESS_CUSTOMER("customer");



    private final String access;

    private Access(String s) {
        access = s;
    }

    public String toString() {
        return this.access;
    }
}
