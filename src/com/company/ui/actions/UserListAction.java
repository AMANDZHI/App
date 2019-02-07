package com.company.ui.actions;

import com.company.ui.ServiceLocator;

import java.io.IOException;

public class UserListAction implements Action {
    private final ServiceLocator serviceLocator;

    public UserListAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        System.out.println(serviceLocator.getUserService().getList());
    }
}