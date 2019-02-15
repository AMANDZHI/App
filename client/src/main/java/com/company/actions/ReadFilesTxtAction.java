//package com.company.actions;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.Project;
//import com.company.model.Task;
//import com.company.model.User;
//import com.company.util.ActionRole;
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ReadFilesTxtAction implements Action {
//    private ServiceLocator serviceLocator;
//
//    @Override
//    public String getName() {
//        return "readFilesTxtToAllRepo";
//    }
//
//    @Override
//    public String getDescription() {
//        return "deserialization txt data to objects";
//    }
//
//    @Override
//    @SneakyThrows
//    public  void execute() {
//        String filePathUsers = "exportData/users.txt";
//        String filePathTasks = "exportData/tasks.txt";
//        String filePathProjects = "exportData/projects.txt";
//
//        List<Project> listProjects = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathProjects);
//        List<User> listUsers = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathUsers);
//        List<Task> listTasks = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathTasks);
//
//        for (User u: listUsers) {
//            if (!serviceLocator.getUserServiceDB().findByLogin(u.getLogin()).isPresent()) {
//                serviceLocator.getUserServiceDB().save(u);
//            }
//        }
//
//        for (Project p: listProjects) {
//            if (!serviceLocator.getProjectServiceDB().findById(p.getId()).isPresent()) {
//                serviceLocator.getProjectServiceDB().save(p);
//            }
//        }
//
//        for (Task t: listTasks) {
//            if (!serviceLocator.getTaskServiceDB().findById(t.getId()).isPresent()) {
//                serviceLocator.getTaskServiceDB().save(t);
//            }
//        }
//
//        System.out.println("Успешно");
//    }
//
//    @Override
//    public ActionRole getRole() {
//        return ActionRole.ADMIN;
//    }
//
//    @Override
//    public void setServiceLocator(ServiceLocator serviceLocator) {
//        this.serviceLocator = serviceLocator;
//    }
//}
