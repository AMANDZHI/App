package com.company;

import com.company.actions.*;
import com.company.apiClient.Action;
import com.company.ui.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Initializer {

    @Autowired
    private Menu menu;

    @Autowired
    private ProjectCreateAction projectCreateAction;
    @Autowired
    private ProjectFindAction projectFindAction;
    @Autowired
    private ProjectListAction projectListAction;
    @Autowired
    private ProjectRemoveAction projectRemoveAction;
    @Autowired
    private ProjectUpdateAction projectUpdateAction;

    @Autowired
    private TaskCreateAction taskCreateAction;
    @Autowired
    private TaskFindAction taskFindAction;
    @Autowired
    private TaskListAction taskListAction;
    @Autowired
    private TaskRemoveAction taskRemoveAction;
    @Autowired
    private TaskUpdateAction taskUpdateAction;

    @Autowired
    private LogOutAction logOutAction;
    @Autowired
    private LoginAction loginAction;

    @Autowired
    private UserCreateAction userCreateAction;
    @Autowired
    private UserFindAction userFindAction;
    @Autowired
    private UserListAction userListAction;
    @Autowired
    private UserRemoveAction userRemoveAction;
    @Autowired
    private UserUpdateAction userUpdateAction;

    @Autowired
    private ReadFileJsonAction readFileJsonAction;
    @Autowired
    private ReadFilesTxtAction readFilesTxtAction;
    @Autowired
    private ReadFileXmlAction readFileXmlAction;
    @Autowired
    private WriteAllToFilesJsonAction writeAllToFilesJsonAction;
    @Autowired
    private WriteAllToFilesTxtAction writeAllToFilesTxtAction;
    @Autowired
    private WriteAllToFilesXmlAction writeAllToFilesXmlAction;

    private final Map<String, Action> map = new HashMap<>();
    private final List<Action> listForAction = new ArrayList<>();

    @PostConstruct
    public void run() {
        init();
        menu.setMap(map);
        menu.startMenu();
    }

    private void init() {
        Action[] action = {projectCreateAction, projectFindAction, projectListAction, projectRemoveAction, projectUpdateAction, taskCreateAction, taskFindAction, taskListAction, taskRemoveAction, taskUpdateAction, userCreateAction, userFindAction, userListAction, userRemoveAction, userUpdateAction, loginAction, logOutAction, writeAllToFilesJsonAction, writeAllToFilesTxtAction, writeAllToFilesXmlAction, readFileJsonAction, readFilesTxtAction, readFileXmlAction};

        for (Action a: action) {
            listForAction.add(a);
        }

        for (Action a : listForAction) {
            map.put(a.getName(), a);
        }
    }
}