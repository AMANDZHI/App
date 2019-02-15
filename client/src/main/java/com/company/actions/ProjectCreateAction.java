//package com.company.actions;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.Project;
//import com.company.util.ActionRole;
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class ProjectCreateAction implements Action {
//    private ServiceLocator serviceLocator;
//
//    @Override
//    public String getName() {
//        return "saveProject";
//    }
//
//    @Override
//    public String getDescription() {
//        return "Save your project";
//    }
//
//    @Override
//    @SneakyThrows
//    public void execute() {
//        String answerNameProject = CommonReader.getNameProject();
//        String answerDescrProject = CommonReader.getDescrProject();
//        Project newProject = new Project(answerNameProject, answerDescrProject, serviceLocator.getSessionService().getSession().getUser());
//
//        if (!serviceLocator.getProjectServiceDB().findByName(newProject.getName()).isPresent()) {
//            if (serviceLocator.getProjectServiceDB().save(newProject)) {
//                System.out.println(newProject);
//            } else {
//                System.out.println("Не удалось сохранить проект в базу");
//            }
//        } else {
//            System.out.println("Уже есть проект с таким именем");
//        }
//    }
//
//    @Override
//    public ActionRole getRole() {
//        return ActionRole.USER;
//    }
//
//    @Override
//    public void setServiceLocator(ServiceLocator serviceLocator) {
//        this.serviceLocator = serviceLocator;
//    }
//}