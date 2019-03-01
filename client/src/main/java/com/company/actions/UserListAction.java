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

import java.util.List;

@Component
public class UserListAction implements Action {

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "getListUsers";
    }

    @Override
    public String getDescription() {
        return "get all users";
    }

    @Override
    @SneakyThrows
    public void execute() {
        Session session = clientSessionService.getSession();
        List<UserDTO> listUser = userWebService.getListUser(session);
        for (UserDTO u: listUser) {
            System.out.println("login: " +  u.getLogin());
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}