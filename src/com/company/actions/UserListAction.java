package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.util.Role;

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
    public boolean execute() throws IOException {
        System.out.println(serviceLocator.getUserServiceDB().getList());
        return true;
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}