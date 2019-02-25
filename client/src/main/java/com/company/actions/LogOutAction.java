package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogOutAction implements Action {

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "logOut";
    }

    @Override
    public String getDescription() {
        return "log out remote system";
    }

    @Override
    @SneakyThrows
    public void execute() {
        clientSessionService.save(null);
        System.out.println("Вышли из системы");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}