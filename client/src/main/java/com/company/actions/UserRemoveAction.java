package com.company.actions;

import com.company.ActionRole;
import com.company.api.UserWebServiceEndpoint;
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
        UserWebServiceEndpoint userWebService = serviceLocatorEndpoint.getUserWebService();
        boolean removeUser = userWebService.removeByLoginUser(answerLoginUser, session);
        if (removeUser) {
            System.out.println("Готово");
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