package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.Map;

public class WriteTasksToJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeTasksToJson";
    }

    @Override
    public String getDescription() {
        return "serialization Tasks data to Json";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();

        if (mapTasks.size() != 0) {
            serviceLocator.getTaskSerializationServiceImpl().writeObjectToJson(answerNameFilePath, mapTasks);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
