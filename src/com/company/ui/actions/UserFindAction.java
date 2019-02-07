package com.company.ui.actions;

import com.company.model.User;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class UserFindAction implements Action {
    private final ServiceLocator serviceLocator;

    public UserFindAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "findUser";
    }

    @Override
    public String getDescription() {
        return "find user";
    }

    @Override
    public void execute() throws IOException {
        String answerIdUser = CommonReader.getIdUser();
        User findUser = serviceLocator.getUserService().findById(Integer.parseInt(answerIdUser));
        System.out.println(findUser);
    }
}