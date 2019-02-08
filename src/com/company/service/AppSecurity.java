package com.company.service;

import com.company.api.ServiceLocator;
import com.company.model.Session;
import com.company.model.User;

import java.util.Map;

public class AppSecurity {
    private final ServiceLocator serviceLocator;

    public AppSecurity(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean authorization(User user) {
        Map<String, User> map = serviceLocator.getUserService().getMap();
        boolean check = false;
        for (Map.Entry<String, User> pair: map.entrySet()) {
            if (pair.getValue().getLogin().equals(user.getLogin()) && pair.getValue().getPassword().equals(user.getPassword())) {
                check = true;
                User findUser = serviceLocator.getUserService().findByLogin(user.getLogin());
                serviceLocator.getSessionService().save(new Session(findUser));
            }
        }
        return check;
    }

    public void logOut() {
        serviceLocator.getSessionService().invalidate();
    }
}