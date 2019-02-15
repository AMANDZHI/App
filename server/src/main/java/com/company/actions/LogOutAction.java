package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.util.ActionRole;

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
    public void execute() throws IOException {
        serviceLocator.getSessionService().invalidate();
        System.out.println("Вышли из системы");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}