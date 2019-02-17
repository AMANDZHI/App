package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import lombok.SneakyThrows;

public class UserRemoveAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "removeUser";
    }

    @Override
    public String getDescription() {
        return "removeByLogin user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLoginUser = CommonReader.getLoginUser();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        boolean answerRemove = serviceLocatorEndpoint.getUserWebService().removeByLoginUser(answerLoginUser, session);
        if (answerRemove) {
            System.out.println("Успещно");
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