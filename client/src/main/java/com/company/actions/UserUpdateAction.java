package com.company.actions;

import com.company.ActionRole;
import com.company.api.Session;
import com.company.api.UserDTO;
import com.company.api.UserWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateAction implements Action {

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @Autowired
    private ClientSessionService clientSessionService;

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

        Session session = clientSessionService.getSession();

        UserDTO user = userWebService.updateUser(answerLoginUser, answerNewNameUser, answerNewLoginUser, answerPasswordUser, answerRoleUser, session);
        System.out.println(user);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}
