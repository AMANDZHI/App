package com.company;

import com.company.api.Project;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Session;
import com.company.api.SessionWebServiceEndpoint;
import com.company.endpoint.ProjectWebServiceEndpointImplService;
import com.company.endpoint.SessionWebServiceEndpointImplService;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Application {
    //private final static Class[] classes = {ProjectCreateAction.class, ProjectFindAction.class, ProjectListAction.class, ProjectRemoveAction.class, ProjectUpdateAction.class, TaskCreateAction.class, TaskFindAction.class, TaskListAction.class, TaskRemoveAction.class, TaskUpdateAction.class,LogOutAction.class, LoginAction.class, RegistrationAction.class, UserCreateAction.class, UserFindAction.class, UserListAction.class, UserRemoveAction.class, UserUpdateAction.class, WriteAllToFilesTxtAction.class, WriteAllToFilesJsonAction.class, WriteAllToFilesXmlAction.class, ReadFilesTxtAction.class, ReadFileJsonAction.class, ReadFileXmlAction.class};

    public static void main(String[] args) throws MalformedURLException {

        SessionWebServiceEndpoint sessionWebServiceEndpoint = new SessionWebServiceEndpointImplService().getSessionWebServiceEndpointImplPort();
        Session session = sessionWebServiceEndpoint.openSession("admin", "admin");
        System.out.println(session.getToken());

        ProjectWebServiceEndpoint projectWebServiceEndpoint = new ProjectWebServiceEndpointImplService().getProjectWebServiceEndpointImplPort();
        List<Project> list = projectWebServiceEndpoint.getList(session);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Project> list = projectWebServiceEndpoint.getList(session);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getName());
                }
            }
        }, 1000*40);
    }
}