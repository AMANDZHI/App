package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserRemoveAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "removeUser";
    }

    @Override
    public String getDescription() {
        return "remove user";
    }

    @Override
    public void execute() throws IOException {
        String answerLoginUser = CommonReader.getLoginUser();

        User user = serviceLocator.getUserService().findByLogin(answerLoginUser);
        if (user != null) {
            if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                serviceLocator.getUserService().removeByLogin(answerLoginUser);
                System.out.println("Удален юзер");
            } else {
                System.out.println("Нельзя удалить себя");
            }
        } else {
            System.out.println("Нет такого юзера");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}