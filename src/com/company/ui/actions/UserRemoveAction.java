package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.User;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class UserRemoveAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public UserRemoveAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
    }

    @Override
    public String getName() {
        return "removeUser";
    }

    @Override
    public String getDescription() {
        return "remove user";
    }

    @Override
    public void execute() throws IOException {
        String answerIdUser = CommonReader.getIdUser();

        User user = serviceLocator.getUserService().findById(Integer.parseInt(answerIdUser));
        if (user != null) {
            if (!user.equals(session.getUser())) {
                serviceLocator.getUserService().removeById(Integer.parseInt(answerIdUser));
                System.out.println("Удален юзер");
            } else {
                System.out.println("Нельзя удалить себя");
            }
        }
    }
}