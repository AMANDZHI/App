package com.company.ui;

import com.company.ui.actions.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private List<Command> listStart;
    private List<Command> listActionProject;
    private List<Command> listActionTask;
    private BufferedReader reader;
    private HashMap<Command, Action> map;

    public Menu(List<Command> listStart, List<Command> listActionProject, List<Command> listActionTask, BufferedReader reader, HashMap<Command, Action> map) {
        this.listStart = listStart;
        this.listActionProject = listActionProject;
        this.listActionTask = listActionTask;
        this.reader = reader;
        this.map = map;

    }

    public void startMenu() throws IOException {
        System.out.println("Выберите проект или задачу. Введите текст");

        for (Command c: listStart) {
            System.out.println(c);
        }

        String answer = reader.readLine();
        String goToProject = "goToProject";
        String goToTask = "goToTask";

        if (answer.equals(goToProject)) {
            System.out.println("Выберите действие. Введите текст");

            for (Command c: listActionProject) {
                System.out.println(c);
            }

            String answerActionProject = reader.readLine();

            String save = "saveProject";
            String find = "findProject";
            String update = "updateProject";
            String remove = "removeProject";
            String getList = "getListProjects";

            for (Map.Entry<Command, Action> pair: map.entrySet()) {
                if (pair.getKey().getName().equals(answerActionProject)) {
                    pair.getValue().execute();
                }
            }

        } else if (answer.equals(goToTask)) {
            System.out.println("Выберите действие. Введите текст");

            for (Command c: listActionTask) {
                System.out.println(c);
            }

            String answerActionTask = reader.readLine();

            String save = "saveTask";
            String find = "findTask";
            String update = "updateTask";
            String remove = "removeTask";
            String getList = "getListTasks";

            for (Map.Entry<Command, Action> pair: map.entrySet()) {
                if (pair.getKey().getName().equals(answerActionTask)) {
                    pair.getValue().execute();
                }
            }
        }

        this.startMenu();
    }
}