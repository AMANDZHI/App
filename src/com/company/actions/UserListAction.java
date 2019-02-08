package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserListAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "getListUsers";
    }

    @Override
    public String getDescription() {
        return "get all users";
    }

    @Override
    public void execute() throws IOException {
        System.out.println(serviceLocator.getUserService().getMap());
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}