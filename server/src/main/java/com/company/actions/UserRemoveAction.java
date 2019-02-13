package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;
import com.company.util.ActionRole;

import java.io.IOException;
import java.util.Optional;

public class UserRemoveAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "removeUser";
    }

    @Override
    public String getDescription() {
        return "removeByLogin user";
    }

    @Override
    public boolean execute() throws IOException {
        String answerLoginUser = CommonReader.getLoginUser();

        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
        if (optionalUser.isPresent()) {
            if (!optionalUser.get().equals(serviceLocator.getSessionService().getSession().getUser())) {
                if (serviceLocator.getUserServiceDB().removeByLogin(answerLoginUser)) {
                    System.out.println("Удален юзер");
                    return true;
                } else {
                    System.out.println("Не удалось удалить юзера из базы");
                    return false;
                }
            } else {
                System.out.println("Нельзя удалить себя");
                return false;
            }
        } else {
            System.out.println("Нет такого юзера");
            return false;
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