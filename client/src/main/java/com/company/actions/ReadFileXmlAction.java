//package com.company.actions;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.Domain;
//import com.company.model.Project;
//import com.company.model.Task;
//import com.company.model.User;
//import com.company.util.ActionRole;
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//import java.util.List;
//
//public class ReadFileXmlAction implements Action {
//    private ServiceLocator serviceLocator;
//
//    @Override
//    public String getName() {
//        return "readFileXmlToAllRepo";
//    }
//
//    @Override
//    public String getDescription() {
//        return "deserialization file Xml data to objects";
//    }
//
//    @Override
//    @SneakyThrows
//    public void execute() {
//        String filePath = "exportData/all.xml";
//
//        Domain domain = serviceLocator.getSerializationServiceImpl().readXmlToObjects(filePath);
//
//        List<User> listUsers = domain.getUserList();
//        List<Project> listProjects = domain.getProjectList();
//        List<Task> listTasks = domain.getTaskList();
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