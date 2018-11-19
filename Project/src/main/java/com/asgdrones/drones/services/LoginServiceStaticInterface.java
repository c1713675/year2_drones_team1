package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;

public interface LoginServiceStaticInterface {
    Login findByLoginDetails(String un, String pw);
    void signup(Login signupInfo);
    String getAccessValue(String un);
}
