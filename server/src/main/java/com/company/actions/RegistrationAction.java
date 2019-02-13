package com.company.actions;

import com.company.api.Action;
import com.company.model.User;
import com.company.api.ServiceLocator;
import com.company.util.ActionRole;
import com.company.util.UserRole;

import java.io.IOException;
import java.util.Optional;

public class RegistrationAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "registration";
    }

    @Override
    public String getDescription() {
        return "registration your account";
    }

    @Override
    public boolean execute() throws IOException {
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        User newUser = new User(answerNameUser, answerLoginUser, answerPasswordUser, UserRole.USER);
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(newUser.getLogin());
        if (!optionalUser.isPresent()) {
            if (serviceLocator.getUserServiceDB().save(newUser)) {
                System.out.println(newUser);
                serviceLocator.getSessionService().getSession().setUser(serviceLocator.getUserServiceDB().findByLogin(newUser.getLogin()).get());
                return true;
            } else {
                System.out.println("Не удалось сохранить в базу");
                return false;
            }
        } else {
            System.out.println("Такой логин уже используется");
            return false;
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.GUEST;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
