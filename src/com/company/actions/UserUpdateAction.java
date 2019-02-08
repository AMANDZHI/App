package com.company.actions;

import com.company.api.Action;
import com.company.model.Session;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserUpdateAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "updateUser";
    }

    @Override
    public String getDescription() {
        return "update your user";
    }

    @Override
    public void execute() throws IOException {
        String answerNewNameUser = CommonReader.getNewNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerNewLoginUser = CommonReader.getNewLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();

        User user = serviceLocator.getUserService().findByLogin(answerLoginUser);
        if (user != null) {
            if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                user.setName(answerNewNameUser);
                user.setLogin(answerNewLoginUser);
                user.setPassword(answerPasswordUser);
                serviceLocator.getUserService().update(user);
                System.out.println(user);
            } else {
                user.setName(answerNewNameUser);
                user.setLogin(answerNewLoginUser);
                user.setPassword(answerPasswordUser);
                serviceLocator.getUserService().update(user);
                serviceLocator.getSessionService().save(new Session(user));
                System.out.println(user);
            }
        } else {
            System.out.println("Не найден юзер с таким логином");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
