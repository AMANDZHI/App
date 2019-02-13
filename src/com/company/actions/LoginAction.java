package com.company.actions;

import com.company.api.Action;
import com.company.api.AuthAction;
import com.company.api.ServiceLocator;
import com.company.model.User;
import com.company.util.Role;

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
    public boolean execute() throws IOException {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        User user = new User(answerLogin, answerPassword);
        if (serviceLocator.getAppSecurity().authorization(user)) {
            return true;
        }
        return false;
    }

    @Override
    public Role getRole() {
        return Role.GUEST;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}