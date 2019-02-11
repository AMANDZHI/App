package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteUsersToFileAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeUsersToFileTxt";
    }

    @Override
    public String getDescription() {
        return "serialization Users data to txt";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForUsers();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();

        if (mapUsers.size() != 0) {
            serviceLocator.getUserSerializationServiceImpl().writeObjectToFile(answerNameFilePath, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
