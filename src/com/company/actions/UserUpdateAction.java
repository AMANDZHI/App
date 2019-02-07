package com.company.actions;

import com.company.api.Action;
import com.company.model.Session;
import com.company.model.User;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class UserUpdateAction implements Action {
    private final ServiceLocator serviceLocator;

    public UserUpdateAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdUser = CommonReader.getIdUser();
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();

        User user = serviceLocator.getUserService().findById(Integer.parseInt(answerIdUser));
        if (user != null) {
            if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                User updateUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
                serviceLocator.getUserService().update(updateUser);
                System.out.println(updateUser);
            } else {
                User updateUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
                serviceLocator.getUserService().update(updateUser);
                serviceLocator.getSessionService().save(new Session(updateUser));
                System.out.println(updateUser);
            }
        } else {
            System.out.println("Не найден юзер с таким id");
        }
        User updateUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
        serviceLocator.getUserService().update(updateUser);
        System.out.println(updateUser);
    }
}
