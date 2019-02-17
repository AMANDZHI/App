package com.company.actions;


import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import lombok.SneakyThrows;

public class LoginAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "Login to remote system";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        Session session = serviceLocatorEndpoint.getSessionWebService().openSession(answerLogin, answerPassword);
        System.out.println(session);
        serviceLocatorEndpoint.getClientSessionService().save(session);
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.GUEST;
    }
}