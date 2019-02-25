package com.company.actions;

import com.company.ActionRole;
import com.company.api.Session;
import com.company.api.User;
import com.company.api.UserWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreateAction implements Action {

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "saveUser";
    }

    @Override
    public String getDescription() {
        return "save your user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameUser = CommonReader.getNameUser();
        String answerLoginUser = CommonReader.getLoginUser();
        String answerPasswordUser = CommonReader.getPasswordUser();
        String answerRoleUser = CommonReader.getRoleUser();

        Session session = clientSessionService.getSession();
        User saveUser = userWebService.saveUser(answerNameUser, answerLoginUser, answerPasswordUser, answerRoleUser, session);
        if (saveUser != null) {
            System.out.println("Готово");
        } else {
            System.out.println("Неудачно");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}