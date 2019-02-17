package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.User;
import lombok.SneakyThrows;

public class UserFindAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "findUser";
    }

    @Override
    public String getDescription() {
        return "findByLogin user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLoginUser = CommonReader.getLoginUser();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        User user = serviceLocatorEndpoint.getUserWebService().findByLoginUser(answerLoginUser, session);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Неудачно");
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