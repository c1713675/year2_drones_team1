package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.login.LoginJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceStatic implements LoginService{
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
    public boolean isLoginAdmin(String un) {
        return loginJPA.isLoginAdmin(un);
    }

//    I may need to delete these, along with their repositories. I will see if I need to use them later on in the code
//    The LoginJPA may be enough for all logins.
//    I need to review this later in development.
//    @Override
//    public void signupAdmin(Login signupInfo) {
//        loginJPA.save(signupInfo);
//    }
//
//    @Override
//    public void signupInstructor(Login signupInfo) {
//        loginJPA.save(signupInfo);
//    }


}
