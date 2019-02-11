package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadJsonToTasksAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readJsonToTasksRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization tasks file json to Tasks data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        Map<String, Task> map = new HashMap<>();

        map = serviceLocator.getTaskSerializationServiceImpl().readJsonToObject(answerNameFilePath);
        serviceLocator.getTaskService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
