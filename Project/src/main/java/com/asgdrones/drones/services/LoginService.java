package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;

public interface LoginService {
    Login findByLoginDetails(String un, String pw);
    void signup(Login signupInfo);
    void signupAdmin(Login signupInfo);
    void signupInstructor(Login signupInfo);
}
