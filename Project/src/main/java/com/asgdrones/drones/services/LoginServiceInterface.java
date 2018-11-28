package com.asgdrones.drones.services;

import com.asgdrones.drones.domain.Login;

import java.util.List;

public interface LoginServiceInterface {
    public String checkLogin(Login login);
    public String getUsername(Login login);
    public Long getUserID(Login login);
}
