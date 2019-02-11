package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadXmlToUsersAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readXmlToUsersRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization users file Xml to Users data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForUsers();
        Map<String, User> map = new HashMap<>();

        map = serviceLocator.getUserSerializationServiceImpl().readXmlToObject(answerNameFilePath);
        serviceLocator.getUserService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
