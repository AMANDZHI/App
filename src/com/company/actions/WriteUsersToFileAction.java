package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteUsersToFileAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeUsersToFile";
    }

    @Override
    public String getDescription() {
        return "serialization Users data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForUsers();
        serviceLocator.getUserSerializationServiceImpl().writeObjectToFile(answerNameFilePath, serviceLocator.getUserService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
