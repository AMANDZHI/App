package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.User;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class UserUpdateAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public UserUpdateAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
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
            if (!user.equals(session.getUser())) {
                User updateUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
                serviceLocator.getUserService().update(updateUser);
                System.out.println(updateUser);
            } else {
                User updateUser = new User(Integer.parseInt(answerIdUser), answerNameUser, answerLoginUser, answerPasswordUser);
                serviceLocator.getUserService().update(updateUser);;
                session.save(updateUser);
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
