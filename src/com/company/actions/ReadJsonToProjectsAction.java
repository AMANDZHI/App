package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadJsonToProjectsAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readJsonToProjectsRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization projects file json to projects data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForProjects();
        Map<String, Project> map = new HashMap<>();

        map = serviceLocator.getProjectSerializationServiceImpl().readJsonToObject(answerNameFilePath);
        serviceLocator.getProjectService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
