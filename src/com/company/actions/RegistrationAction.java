package com.company.actions;

import com.company.api.AuthAction;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;
import java.util.Optional;

public class RegistrationAction implements AuthAction {
    private ServiceLocator serviceLocator;

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
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        User newUser = new User(answerNameUser, answerLoginUser, answerPasswordUser);
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(newUser.getLogin());
        if (optionalUser.isPresent()) {
            if (serviceLocator.getUserServiceDB().save(newUser)) {
                System.out.println(newUser);
                return newUser;
            } else {
                System.out.println("Не удалось сохранить в базу");
                return null;
            }
        } else {
            System.out.println("Такой логин уже используется");
            return null;
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
