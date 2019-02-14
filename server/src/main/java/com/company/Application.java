package com.company;

import com.company.actions.*;

public class Application {
    private final static Class[] classes = {ProjectCreateAction.class, ProjectFindAction.class, ProjectListAction.class, ProjectRemoveAction.class, ProjectUpdateAction.class, TaskCreateAction.class, TaskFindAction.class, TaskListAction.class, TaskRemoveAction.class, TaskUpdateAction.class,LogOutAction.class, LoginAction.class, RegistrationAction.class, UserCreateAction.class, UserFindAction.class, UserListAction.class, UserRemoveAction.class, UserUpdateAction.class, WriteAllToFilesTxtAction.class, WriteAllToFilesJsonAction.class, WriteAllToFilesXmlAction.class, ReadFilesTxtAction.class, ReadFileJsonAction.class, ReadFileXmlAction.class};

    public static void main(String[] args) {
	 Initializer initializer = new Initializer();
	 initializer.run(classes);
    }
}