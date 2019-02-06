package com.company.dao.config;

import com.company.model.User;
import com.company.ui.ServiceLocator;

public class AppSecurityConfig {
    private final ServiceLocator serviceLocator;

    public AppSecurityConfig(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean authorization(User user) {
        if (serviceLocator.getUserService().findById(user.getId()) != null) {
            return true;
        } else {
            return false;
        }
    }
}