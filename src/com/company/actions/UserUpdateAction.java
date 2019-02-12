package com.company.actions;

import com.company.api.Action;
import com.company.model.Session;
import com.company.model.User;
import com.company.api.ServiceLocator;
import com.company.util.Role;

import java.io.IOException;
import java.util.Optional;

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
        String answerPasswordUser = CommonReader.getNewPasswordUser();

        if (serviceLocator.getUserServiceDB().findByLogin(answerNewLoginUser).isPresent()) {
            Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                    user.setName(answerNewNameUser);
                    user.setLogin(answerNewLoginUser);
                    user.setPassword(answerPasswordUser);
                    if (serviceLocator.getUserServiceDB().update(user)) {
                        System.out.println(user);
                    } else {
                        System.out.println("Не удалось обновить юзера в базе");
                    }
                } else {
                    user.setName(answerNewNameUser);
                    user.setLogin(answerNewLoginUser);
                    user.setPassword(answerPasswordUser);
                    if (serviceLocator.getUserServiceDB().update(user)) {
                        serviceLocator.getSessionService().save(new Session(user));
                        System.out.println(user);
                    } else {
                        System.out.println("Не удалось обновить юзера в базе");
                    }

                }
            } else {
                System.out.println("Не найден юзер с таким логином");
            }
        } else {
            System.out.println("Такой новый логин уже используется");
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
