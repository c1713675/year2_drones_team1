package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.login.LoginJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceStatic implements LoginServiceStaticInterface {
    private LoginJPA loginJPA;

    @Autowired
    public LoginServiceStatic(LoginJPA jpa){
        loginJPA = jpa;
    }

    @Override
    public Login findByLoginDetails(String un, String pw) {
        return loginJPA.findByLoginDetails(un, pw);
    }

    @Override
    public void signup(Login signupInfo) {
        loginJPA.save(signupInfo);
    }

    @Override
    public String getAccessValue(String un) {
        return loginJPA.getAccessValue(un);
    }

}
