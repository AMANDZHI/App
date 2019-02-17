package com.company.ui;

import com.company.ActionRole;
import com.company.api.User;
import com.company.api.UserRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.util.Map;

public class Menu {
    private final BufferedReader reader;
    private final Map<String, Action> map;
    private final ServiceLocatorEndpoint serviceLocatorEndpoint;

    public Menu(BufferedReader reader, Map<String, Action> map, ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.reader = reader;
        this.map = map;
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @SneakyThrows
    public void startMenu() {
        System.out.println("Введите команду help");

        String answer = reader.readLine();

        if ("help".equals(answer)) {
            System.out.println("Выберите действие. Введите текст команды");

            for (Map.Entry<String, Action> pair : map.entrySet()) {
                if (pair.getValue().getRole().equals(ActionRole.GUEST)) {
                    System.out.println(pair.getValue().getName() + ": " + pair.getValue().getDescription());
                }
            }

            String answerAction = reader.readLine();

            if (map.get(answerAction) == null) {
                startMenu();
            }

            if (map.get(answerAction).equals(map.get("login"))) {
                map.get(answerAction).execute();

                Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
                System.out.println(session + " 2");
                if (serviceLocatorEndpoint.getSessionWebService().checkSession(session)) {
                    authMenu(session);
                } else {
                    startMenu();
                }

            } else {
                startMenu();
            }
        }
    }

    @SneakyThrows
    private void authMenu(Session session) {
        System.out.println("Выберите действие. Введите текст команды");
        User user = serviceLocatorEndpoint.getUserWebService().findByIdUser(session.getUserId(), session);
        if (user != null) {
            if (user.getRole().equals(UserRole.ADMIN)) {
                for (Map.Entry<String, Action> pair : map.entrySet()) {
                    if (!pair.getValue().getRole().equals(ActionRole.GUEST)) {
                        System.out.println(pair.getValue().getName() + ": " + pair.getValue().getDescription());
                    }
                }

                String answerAuth = reader.readLine();

                if (!map.containsKey(answerAuth) || map.get(answerAuth).getRole().equals(ActionRole.GUEST)) {
                    authMenu(session);
                }

                if (serviceLocatorEndpoint.getSessionWebService().checkSession(session)) {
                    map.get(answerAuth).execute();
                    authMenu(session);
                } else {
                    startMenu();
                }

            } else {
                for (Map.Entry<String, Action> pair : map.entrySet()) {
                    if (pair.getValue().getRole().equals(ActionRole.USER)) {
                        System.out.println(pair.getValue().getName() + ": " + pair.getValue().getDescription());
                    }
                }
                String answerAuth = reader.readLine();

                if (!map.containsKey(answerAuth) || !map.get(answerAuth).getRole().equals(ActionRole.USER)) {
                    authMenu(session);
                }

                if (serviceLocatorEndpoint.getSessionWebService().checkSession(session)) {
                    map.get(answerAuth).execute();
                    authMenu(session);
                } else {
                    startMenu();
                }
            }
        }
        else {
        startMenu();
        }
    }
}