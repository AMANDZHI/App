package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteTasksToXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeTasksToXml";
    }

    @Override
    public String getDescription() {
        return "serialization Tasks data to Xml";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        serviceLocator.getTaskSerializationServiceImpl().writeObjectToXml(answerNameFilePath, serviceLocator.getTaskService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
