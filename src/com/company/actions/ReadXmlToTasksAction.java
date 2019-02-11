package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadXmlToTasksAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readXmlToTasksRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization tasks file Xml to Tasks data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForTasks();
        Map<String, Task> map = new HashMap<>();

        map = serviceLocator.getTaskSerializationServiceImpl().readXmlToObject(answerNameFilePath);
        serviceLocator.getTaskService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
