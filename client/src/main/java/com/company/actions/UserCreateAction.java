package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.User;
import com.company.api.UserRole;
import lombok.SneakyThrows;

public class UserCreateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "saveUser";
    }

    @Override
    public String getDescription() {
        return "save your user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        String answerRoleUser = CommonReader.getRoleUser();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();

        User newUser = new User();
        newUser.setName(answerNameUser);
        newUser.setLogin(answerLoginUser);
        newUser.setPassword(answerPasswordUser);
        newUser.setRole(UserRole.valueOf(answerRoleUser));

        boolean answerSave = serviceLocatorEndpoint.getUserWebService().saveUser(newUser, session);
        if (answerSave) {
            System.out.println("Удачно");
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