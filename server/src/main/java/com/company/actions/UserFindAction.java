package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;
import com.company.util.ActionRole;

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
    public void execute() throws IOException {
        String answerLoginUser = CommonReader.getLoginUser();
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
        if (optionalUser.isPresent()) {
            System.out.println(optionalUser.get());
        } else {
            System.out.println("Не найден юзер с таким логином");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}