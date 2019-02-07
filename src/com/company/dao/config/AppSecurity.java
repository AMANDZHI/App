package com.company.dao.config;

import com.company.model.User;
import com.company.ui.ServiceLocator;

import java.util.List;

public class AppSecurity {
    private final ServiceLocator serviceLocator;
    private final  Session session;

    public AppSecurity(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
    }

    public boolean authorization(User user) {
        List<User> list = serviceLocator.getUserService().getList();
        boolean check = false;
        for (User u: list) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                check = true;
                session.save(u);
            }
        }
        return check;
    }

    public void logOut() {
        session.invalidate();
    }
}