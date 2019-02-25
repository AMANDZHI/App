package com.company.ui;

import com.company.ActionRole;
import com.company.api.*;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@Component
public class Menu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Map<String, Action> map;

    public void setMap(Map<String, Action> map) {
        this.map = map;
    }

    @Autowired
    private ClientSessionService clientSessionService;

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private UserWebServiceEndpoint userWebService;

    public Menu(Map<String, Action> map) {
        this.map = map;
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

                Session session = clientSessionService.getSession();
                if (sessionWebServiceEndpoint.checkSession(session)) {
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
        User user = userWebService.findByIdUser(session.getUserId(), session);
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

                if (sessionWebServiceEndpoint.checkSession(session)) {
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

                if (sessionWebServiceEndpoint.checkSession(session)) {
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