package com.company;

import com.company.actions.*;

public class Application {
    private final static Class[] classes = {ProjectCreateAction.class, ProjectFindAction.class, ProjectListAction.class, ProjectRemoveAction.class, ProjectUpdateAction.class, TaskCreateAction.class, TaskFindAction.class, TaskListAction.class, TaskRemoveAction.class, TaskUpdateAction.class, LogOutAction.class, LoginAction.class, UserCreateAction.class, UserFindAction.class, UserListAction.class, UserRemoveAction.class, UserUpdateAction.class, ReadFileJsonAction.class, ReadFilesTxtAction.class, ReadFileXmlAction.class, WriteAllToFilesJsonAction.class, WriteAllToFilesTxtAction.class, WriteAllToFilesXmlAction.class};

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        initializer.run(classes);
    }
}