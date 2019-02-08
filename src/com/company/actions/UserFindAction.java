package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserFindAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "findUser";
    }

    @Override
    public String getDescription() {
        return "find user";
    }

    @Override
    public void execute() throws IOException {
        String answerLoginUser = CommonReader.getLoginUser();
        User findUser = serviceLocator.getUserService().findByLogin(answerLoginUser);
        if (findUser != null) {
            System.out.println(findUser);
        } else {
            System.out.println("Не найден юзер с таким логином");
        }

    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}