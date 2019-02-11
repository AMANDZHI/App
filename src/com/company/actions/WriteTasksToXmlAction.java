package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.Map;

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
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();

        if (mapTasks.size() != 0) {
            serviceLocator.getTaskSerializationServiceImpl().writeObjectToXml(answerNameFilePath, mapTasks);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
