package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteUsersToXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeUsersToXml";
    }

    @Override
    public String getDescription() {
        return "serialization Users data to Xml";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForUsers();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();

        if (mapUsers.size() != 0) {
            serviceLocator.getUserSerializationServiceImpl().writeObjectToXml(answerNameFilePath, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
