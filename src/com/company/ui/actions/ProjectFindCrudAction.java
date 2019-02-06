package com.company.ui.actions;

import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectFindCrudAction implements CrudAction {
    private final BufferedReader reader;
    private final ServiceLocator serviceLocator;

    public ProjectFindCrudAction(BufferedReader reader, ServiceLocator serviceLocator) {
        this.reader = reader;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "findProject";
    }

    @Override
    public String getDescription() {
        return "FindById your project";
    }

    @Override
    public void execute() throws IOException {
        String answerIdProject = CommonReader.getIdProject();
        Project findProject = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject)-1);
        System.out.println(findProject);
    }
}