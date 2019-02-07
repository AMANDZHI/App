package com.company.service;

import com.company.api.ServiceLocator;
import com.company.model.Session;
import com.company.model.User;

import java.util.List;

public class AppSecurity {
    private final ServiceLocator serviceLocator;

    public AppSecurity(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean authorization(User user) {
        List<User> list = serviceLocator.getUserService().getList();
        boolean check = false;
        for (User u: list) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                check = true;
                serviceLocator.getSessionService().save(new Session(user));
            }
        }
        return check;
    }

    public void logOut() {
        serviceLocator.getSessionService().invalidate();
    }
}