package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;
import com.asgdrones.drones.repositories.LoginRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//<<<<<<< HEAD import java.util.List;
//
//public interface LoginService {
//    Login findByLoginDetails(String un, String pw);
//    void signup(Login signupInfo);
//    boolean isLoginAdmin(String un);
////    void signupAdmin(Login signupInfo);
////    void signupInstructor(Login signupInfo);
//=======
//import com.asgdrones.drones.repositories.LoginRepoJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;

@Service
public class LoginService implements LoginServiceInterface {
    private LoginRepoJPA loginRepoJPA;

    @Autowired
    LoginService(LoginRepoJPA lRepo) {
        loginRepoJPA = lRepo;
    }

    @Override
    public String checkLogin(Login login) {
        List<Login> loginList = loginRepoJPA.findByUsernameAndPassword(login.getUsername(),
                login.getPassword());
        if (loginList.isEmpty()) {
            String permission = "none";
            return permission;
        } else {
            String permission = loginList.get(0).getAccess();
            return permission;
        }
    }

    @Override
    public String getUsername(Login login) {
        List<Login> loginList = loginRepoJPA.findByUsernameAndPassword(login.getUsername(),
                login.getPassword());
        if (loginList.isEmpty()) {
            return null;
        } else {
            String username = loginList.get(0).getUsername();
            return username;
        }
    }
}