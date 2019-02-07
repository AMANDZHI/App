package com.company.actions;

import com.company.api.AuthAction;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class RegistrationAction implements AuthAction {
    private final ServiceLocator serviceLocator;

    public RegistrationAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "registration";
    }

    @Override
    public String getDescription() {
        return "registration your account";
    }

    @Override
    public User execute() throws IOException {
        String answerIdUser = CommonReader.getIdUser();
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        User newUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
        if (serviceLocator.getUserService().findByLogin(newUser.getLogin()) == null) {
            serviceLocator.getUserService().save(newUser);
            System.out.println(newUser);
            return newUser;
        } else {
            System.out.println("Такой логин уже используется");
            return null;
        }
    }
}
