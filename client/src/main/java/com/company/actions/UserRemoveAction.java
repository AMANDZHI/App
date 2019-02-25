package com.company.actions;

import com.company.ActionRole;
import com.company.api.UserWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.api.Session;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRemoveAction implements Action {

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "removeUser";
    }

    @Override
    public String getDescription() {
        return "removeByLogin user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLoginUser = CommonReader.getLoginUser();

        Session session = clientSessionService.getSession();
        boolean removeUser = userWebService.removeByLoginUser(answerLoginUser, session);
        if (removeUser) {
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