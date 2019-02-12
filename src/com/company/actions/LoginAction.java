package com.company.actions;

import com.company.api.AuthAction;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.Optional;

public class LoginAction implements AuthAction {
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
    public User execute() throws IOException {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        User user = new User(answerLogin, answerPassword);
        if (serviceLocator.getAppSecurity().authorization(user)) {
//            return serviceLocator.getUserService().findByLogin(answerLogin);
            Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLogin);
            return optionalUser.orElse(null);
        }
        return null;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}