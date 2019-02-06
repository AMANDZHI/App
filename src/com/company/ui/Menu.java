package com.company.ui;

import com.company.ui.actions.CrudAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private BufferedReader reader;
    private HashMap<String, CrudAction> map;

    public Menu(BufferedReader reader, HashMap<String, CrudAction> map) {
        this.reader = reader;
        this.map = map;
    }

    public void startMenu() throws IOException {
        System.out.println("Введите команду help");

        String answer = reader.readLine();

        if ("help".equals(answer)) {
            System.out.println("Выберите действие. Введите текст команды");

            for (Map.Entry<String, CrudAction> e: map.entrySet()) {
                System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
            }

            String answerActionProject = reader.readLine();

            for (Map.Entry<String, CrudAction> pair: map.entrySet()) {
                if (pair.getKey().equals(answerActionProject)) {
                    pair.getValue().execute();
                }
            }
        }

        this.startMenu();
    }
}