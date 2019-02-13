package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;
import com.company.util.Role;

import java.io.IOException;
import java.util.Optional;

public class UserFindAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "findUser";
    }

    @Override
    public String getDescription() {
        return "findByLogin user";
    }

    @Override
    public boolean execute() throws IOException {
        String answerLoginUser = CommonReader.getLoginUser();
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
        if (optionalUser.isPresent()) {
            System.out.println(optionalUser.get());
            return true;
        } else {
            System.out.println("Не найден юзер с таким логином");
            return false;
        }
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}