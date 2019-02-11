package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFileToProjectsAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFileTxtToProjectsRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization projects file txt to projects data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForProjects();
        Map<String, Project> map = new HashMap<>();

        map = serviceLocator.getProjectSerializationServiceImpl().readFileToObject(answerNameFilePath);
        serviceLocator.getProjectService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
