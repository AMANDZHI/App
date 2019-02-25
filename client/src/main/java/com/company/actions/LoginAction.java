package com.company.actions;


import com.company.ActionRole;
import com.company.api.Session;
import com.company.api.SessionWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginAction implements Action {

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "Login to remote system";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerLogin = CommonReader.getLoginUser();
        String answerPassword = CommonReader.getPasswordUser();
        Session session = sessionWebServiceEndpoint.openSession(answerLogin, answerPassword);
        clientSessionService.save(session);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.GUEST;
    }
}