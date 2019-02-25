package com.company.actions;

import com.company.ActionRole;
import com.company.api.UserWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.api.Session;
import com.company.api.User;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFindAction implements Action {

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "findUser";
    }

    @Override
    public String getDescription() {
        return "findByLogin user";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLoginUser = CommonReader.getLoginUser();
        Session session = clientSessionService.getSession();
        User user = userWebService.findByLoginUser(answerLoginUser, session);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Неудачно");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}