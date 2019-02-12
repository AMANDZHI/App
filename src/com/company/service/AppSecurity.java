package com.company.service;

import com.company.api.ServiceLocator;
import com.company.model.Session;
import com.company.model.User;

import java.util.List;
import java.util.Optional;

public class AppSecurity {
    private final ServiceLocator serviceLocator;

    public AppSecurity(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean authorization(User user) {
        List<User> list = serviceLocator.getUserServiceDB().getList();
        boolean check = false;
        for (User u: list) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                check = true;
                Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(user.getLogin());
                serviceLocator.getSessionService().save(new Session(optionalUser.get()));
            }
        }
        return check;
    }

    public void logOut() {
        serviceLocator.getSessionService().invalidate();
    }
}