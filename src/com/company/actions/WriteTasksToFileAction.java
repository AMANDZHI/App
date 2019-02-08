package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteTasksToFileAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeTasksToFile";
    }

    @Override
    public String getDescription() {
        return "serialization Tasks data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        serviceLocator.getTaskSerializationServiceImpl().writeObjectToFile(answerNameFilePath, serviceLocator.getTaskService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
