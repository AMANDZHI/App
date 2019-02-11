package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.Map;

public class WriteTasksToFileAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeTasksToFileTxt";
    }

    @Override
    public String getDescription() {
        return "serialization Tasks data to txt";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();

        if (mapTasks.size() != 0) {
            serviceLocator.getTaskSerializationServiceImpl().writeObjectToFile(answerNameFilePath, mapTasks);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
