package com.company.ui;

import com.company.dao.config.Session;
import com.company.model.User;
import com.company.ui.actions.Action;
import com.company.ui.actions.AuthAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private BufferedReader reader;
    private HashMap<String, Action> map;
    private HashMap<String, AuthAction> mapAuth;
    private HashMap<String, Action> mapAdmAction;
    private Session session;

    public Menu(BufferedReader reader, HashMap<String, Action> map, HashMap<String, AuthAction> mapAuth, HashMap<String, Action> mapAdmAction, Session session) {
        this.reader = reader;
        this.map = map;
        this.mapAuth = mapAuth;
        this.mapAdmAction = mapAdmAction;
        this.session = session;
    }

    public void startMenu() throws IOException {
        System.out.println("Введите команду help");

        String answer = reader.readLine();

        if ("help".equals(answer)) {
            System.out.println("Выберите действие. Введите текст команды");

            for (Map.Entry<String, Action> e: map.entrySet()) {
                System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
            }

            for (Map.Entry<String, AuthAction> e: mapAuth.entrySet()) {
                System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
            }

            String answerAction = reader.readLine();

            if (mapAuth.get(answerAction) == null) {
                startMenu();
            }

            if (mapAuth.get(answerAction).equals(mapAuth.get("login"))) {
                User user = mapAuth.get(answerAction).execute();
                if (user != null) {
                    authMenu(user);
                } else {
                    startMenu();
                }

            } else if (mapAuth.get(answerAction).equals(mapAuth.get("registration"))) {
                User user = mapAuth.get(answerAction).execute();
                if (mapAuth.get(answerAction).execute() != null) {
                    authMenu(user);
                } else {
                    startMenu();
                }
            }
        }
    }

    public void authMenu (User user) throws IOException {
        System.out.println("Выберите действие. Введите текст команды");
            if (user.isAdmin()) {
                for (Map.Entry<String, Action> e: mapAdmAction.entrySet()) {
                    System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
                }

                String answerAction = reader.readLine();

                for (Map.Entry<String, Action> pair: mapAdmAction.entrySet()) {
                    if (pair.getKey().equals(answerAction)) {
                        pair.getValue().execute();
                    }
                }
            } else {
                for (Map.Entry<String, Action> e: map.entrySet()) {
                    System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
                }

                String answerAction = reader.readLine();

                for (Map.Entry<String, Action> pair: map.entrySet()) {
                    if (pair.getKey().equals(answerAction)) {
                        pair.getValue().execute();
                    }
                }
            }

            if (session.getUser() != null) {
                this.authMenu(user);
            } else {
                startMenu();
            }
    }
}