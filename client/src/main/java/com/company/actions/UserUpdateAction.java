package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.User;
import com.company.api.UserRole;
import lombok.SneakyThrows;

public class UserUpdateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "updateUser";
    }

    @Override
    public String getDescription() {
        return "update your user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNewNameUser = CommonReader.getNewNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerNewLoginUser = CommonReader.getNewLoginUser();
        String answerPasswordUser = CommonReader.getNewPasswordUser();
        String answerRoleUser = CommonReader.getRoleUser();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();

        serviceLocatorEndpoint.getUserWebService().updateUser(answerLoginUser, answerNewNameUser, answerNewLoginUser, answerPasswordUser, answerRoleUser, session);

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
