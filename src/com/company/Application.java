package com.company;

import com.company.actions.*;
import com.company.service.UserServiceDBImpl;

import javax.xml.ws.Endpoint;

public class Application {
    private final static Class[] classes = {ProjectCreateAction.class, ProjectFindAction.class, ProjectListAction.class, ProjectRemoveAction.class, ProjectUpdateAction.class, TaskCreateAction.class, TaskFindAction.class, TaskListAction.class, TaskRemoveAction.class, TaskUpdateAction.class,LogOutAction.class, LoginAction.class, RegistrationAction.class, UserCreateAction.class, UserFindAction.class, UserListAction.class, UserRemoveAction.class, UserUpdateAction.class, WriteAllToFilesTxtAction.class, WriteAllToFilesJsonAction.class, WriteAllToFilesXmlAction.class, ReadFilesTxtAction.class, ReadFilesJsonAction.class, ReadFilesXmlAction.class};

    public static void main(String[] args) {
	 Initializer initializer = new Initializer();
	 initializer.run(classes);

        Endpoint.publish("http://localhost:1986/wss/hello", new UserServiceDBImpl());
    }
}