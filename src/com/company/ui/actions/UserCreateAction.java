package com.company.ui.actions;

import com.company.model.User;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;

public class UserCreateAction implements Action {
    private final ServiceLocator serviceLocator;

    public UserCreateAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdUser = CommonReader.getIdUser();
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        String answerAdminUser = CommonReader.getAdminUser();
        User newUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser, Boolean.parseBoolean(answerAdminUser));
        if (serviceLocator.getUserService().findByLogin(newUser.getLogin()) == null) {
            serviceLocator.getUserService().save(newUser);
            System.out.println(newUser);
        } else {
            System.out.println("Такой логин уже используется");
        }
    }
}