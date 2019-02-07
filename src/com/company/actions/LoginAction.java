package com.company.actions;

import com.company.api.AuthAction;
import com.company.service.AppSecurity;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class LoginAction implements AuthAction {
    private final AppSecurity appSecurity;
    private final ServiceLocator serviceLocator;

    public LoginAction(AppSecurity appSecurity, ServiceLocator serviceLocator) {
        this.appSecurity = appSecurity;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "Login to our system";
    }

    @Override
    public User execute() throws IOException {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        User user = new User(answerLogin, answerPassword);
        if (appSecurity.authorization(user)) {
            return serviceLocator.getUserService().findByLogin(answerLogin);
        }
        return null;
    }
}
