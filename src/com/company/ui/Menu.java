package com.company.ui;

import com.company.ui.actions.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private BufferedReader reader;
    private HashMap<String, Action> map;

    public Menu(BufferedReader reader, HashMap<String, Action> map) {
        this.reader = reader;
        this.map = map;
    }

    public void startMenu() throws IOException {
        System.out.println("Введите команду help");

        String answer = reader.readLine();

        if (answer.equals("help")) {
            System.out.println("Выберите действие. Введите текст команды");

            for (Map.Entry<String, Action> e: map.entrySet()) {
                System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
            }

            String answerActionProject = reader.readLine();

            for (Map.Entry<String, Action> pair: map.entrySet()) {
                if (pair.getKey().equals(answerActionProject)) {
                    pair.getValue().execute();
                }
            }
        }

        this.startMenu();
    }
}