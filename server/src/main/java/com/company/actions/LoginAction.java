package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.ActionRole;

import java.io.IOException;
import java.util.Optional;

public class LoginAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "Login to our system";
    }

    @Override
    public void execute() throws IOException {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLogin);
        if (optionalUser.isPresent()) {
            serviceLocator.getSessionService().save(new Session(optionalUser.get()));
            System.out.println("Успешный вход");
        } else {
            System.out.println("Неверный логин или пароль");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.GUEST;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}