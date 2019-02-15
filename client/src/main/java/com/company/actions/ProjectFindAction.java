//package com.company.actions;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.Project;
//import com.company.util.ActionRole;
//import com.company.util.UserRole;
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//import java.util.Optional;
//
//public class ProjectFindAction implements Action {
//    private ServiceLocator serviceLocator;
//
//    @Override
//    public String getName() {
//        return "findProject";
//    }
//
//    @Override
//    public String getDescription() {
//        return "FindById your project";
//    }
//
//    @Override
//    @SneakyThrows
//    public void execute() {
//        String answerNameProject = CommonReader.getNameProject();
//        Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerNameProject);
//        if (optionalProject.isPresent()) {
//            if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().getRole().equals(UserRole.ADMIN)) {
//                System.out.println(optionalProject.get());
//            } else {
//                System.out.println("Нет прав для просмотра проекта");
//            }
//        } else {
//            System.out.println("Не найден такой проект");
//        }
//
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