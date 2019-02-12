package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.Optional;

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
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(newUser.getLogin());
        if (optionalUser.isPresent()) {
            System.out.println("Такой логин уже используется");
        } else {
            if (serviceLocator.getUserServiceDB().save(newUser)) {
                System.out.println(newUser);
            } else {
                System.out.println("Не удалось сохранить в базу юзера");
            }
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}