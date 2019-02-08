package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserCreateAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "saveUser";
    }

    @Override
    public String getDescription() {
        return "save your user";
    }

    @Override
    public void execute() throws IOException {
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        String answerAdminUser = CommonReader.getAdminUser();
        User newUser = new User(answerNameUser, answerLoginUser, answerPasswordUser, Boolean.parseBoolean(answerAdminUser));
        if (serviceLocator.getUserService().findByLogin(newUser.getLogin()) == null) {
            serviceLocator.getUserService().save(newUser);
            System.out.println(newUser);
        } else {
            System.out.println("Такой логин уже используется");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}