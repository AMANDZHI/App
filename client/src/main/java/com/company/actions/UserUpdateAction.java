package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.User;
import com.company.api.UserRole;
import lombok.SneakyThrows;

public class UserUpdateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "updateUser";
    }

    @Override
    public String getDescription() {
        return "update your user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNewNameUser = CommonReader.getNewNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerNewLoginUser = CommonReader.getNewLoginUser();
        String answerPasswordUser = CommonReader.getNewPasswordUser();
        String answerRoleUser = CommonReader.getRoleUser();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        User updateUser = serviceLocatorEndpoint.getUserWebService().findByLoginUser(answerLoginUser, session);

        if (updateUser != null) {
            updateUser.setName(answerNewNameUser);
            updateUser.setLogin(answerNewLoginUser);
            updateUser.setPassword(answerPasswordUser);
            updateUser.setRole(UserRole.valueOf(answerRoleUser));

            boolean answerUpdate = serviceLocatorEndpoint.getUserWebService().updateUser(updateUser, session);
            if (answerUpdate) {
                System.out.println("Успешно");
            } else {
                System.out.println("Не удалось обновить");
            }
        } else {
            System.out.println("Не найден такой юзер");
        }
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}
