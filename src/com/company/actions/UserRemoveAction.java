package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserRemoveAction implements Action {
    private final ServiceLocator serviceLocator;

    public UserRemoveAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdUser = CommonReader.getIdUser();

        User user = serviceLocator.getUserService().findById(Integer.parseInt(answerIdUser));
        if (user != null) {
            if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                serviceLocator.getUserService().removeById(Integer.parseInt(answerIdUser));
                System.out.println("Удален юзер");
            } else {
                System.out.println("Нельзя удалить себя");
            }
        }
    }
}