package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadXmlToProjectsAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readXmlToProjectsRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization Xml to projects data";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForProjects();
        Map<String, Project> map = new HashMap<>();

        map = serviceLocator.getProjectSerializationServiceImpl().readXmlToObject(answerNameFilePath);
        serviceLocator.getProjectService().getRepository().setMap(map);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
