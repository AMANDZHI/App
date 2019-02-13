package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.util.Role;

import java.io.IOException;

public class LogOutAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "logOut";
    }

    @Override
    public String getDescription() {
        return "log out system";
    }

    @Override
    public boolean execute() throws IOException {
        serviceLocator.getAppSecurity().logOut();
        return true;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}