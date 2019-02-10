package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

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
        serviceLocator.getUserSerializationServiceImpl().writeObjectToXml(answerNameFilePath, serviceLocator.getUserService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
