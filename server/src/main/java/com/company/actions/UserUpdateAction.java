package com.company.actions;

import com.company.api.Action;
import com.company.model.Session;
import com.company.model.User;
import com.company.api.ServiceLocator;
import com.company.util.ActionRole;
import com.company.util.UserRole;

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
    public boolean execute() throws IOException {
        String answerNewNameUser = CommonReader.getNewNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerNewLoginUser = CommonReader.getNewLoginUser();
        String answerPasswordUser = CommonReader.getNewPasswordUser();
        String answerRoleUser = CommonReader.getRoleUser();

        if (serviceLocator.getUserServiceDB().findByLogin(answerNewLoginUser).isPresent()) {
            Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (!user.equals(serviceLocator.getSessionService().getSession().getUser())) {
                    user.setName(answerNewNameUser);
                    user.setLogin(answerNewLoginUser);
                    user.setPassword(answerPasswordUser);
                    user.setRole(UserRole.valueOf(answerRoleUser));
                    if (serviceLocator.getUserServiceDB().update(user)) {
                        System.out.println(user);
                        return true;
                    } else {
                        System.out.println("Не удалось обновить юзера в базе");
                        return false;
                    }
                } else {
                    user.setName(answerNewNameUser);
                    user.setLogin(answerNewLoginUser);
                    user.setPassword(answerPasswordUser);
                    if (serviceLocator.getUserServiceDB().update(user)) {
                        serviceLocator.getSessionService().save(new Session(user));
                        System.out.println(user);
                        return true;
                    } else {
                        System.out.println("Не удалось обновить юзера в базе");
                        return false;
                    }

                }
            } else {
                System.out.println("Не найден юзер с таким логином");
                return false;
            }
        } else {
            System.out.println("Такой новый логин уже используется");
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
