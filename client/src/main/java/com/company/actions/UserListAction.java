package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.User;
import lombok.SneakyThrows;

import java.util.List;

public class UserListAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "getListUsers";
    }

    @Override
    public String getDescription() {
        return "get all users";
    }

    @Override
    @SneakyThrows
    public void execute() {
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        List<User> listUser = serviceLocatorEndpoint.getUserWebService().getListUser(session);
        for (User u: listUser) {
            System.out.println("login: " +  u.getLogin());
        }
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}