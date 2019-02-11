package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteUsersToJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeUsersToJson";
    }

    @Override
    public String getDescription() {
        return "serialization Users data to Json";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForUsers();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();

        if (mapUsers.size() != 0) {
            serviceLocator.getUserSerializationServiceImpl().writeObjectToJson(answerNameFilePath, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
