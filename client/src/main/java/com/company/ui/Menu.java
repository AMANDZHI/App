//package com.company.ui;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.User;
//import com.company.util.ActionRole;
//import com.company.util.UserRole;
//import lombok.SneakyThrows;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Map;
//
//public class Menu {
//    private final BufferedReader reader;
//    private final Map<String, Action> map;
//    private final ServiceLocator serviceLocator;
//
//    public Menu(BufferedReader reader, Map<String, Action> map, ServiceLocator serviceLocator) {
//        this.reader = reader;
//        this.map = map;
//        this.serviceLocator = serviceLocator;
//    }
//
//    @SneakyThrows
//    public void startMenu() {
//        System.out.println("Введите команду help");
//
//        String answer = reader.readLine();
//
//        if ("help".equals(answer)) {
//            System.out.println("Выберите действие. Введите текст команды");
//
//            for (Map.Entry<String, Action> e: map.entrySet()) {
//                if (e.getValue().getRole() == ActionRole.GUEST) {
//                    System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
//                }
//            }
//
//            String answerAction = reader.readLine();
//
//            if (map.get(answerAction) == null) {
//                startMenu();
//            }
//
//            if (map.get(answerAction).equals(map.get("login"))) {
//                map.get(answerAction).execute();
//                if (serviceLocator.getSessionService().getSession().getUser() != null) {
//                    User user = serviceLocator.getSessionService().getSession().getUser();
//                    authMenu(user);
//                } else {
//                    startMenu();
//                }
//
//            } else if (map.get(answerAction).equals(map.get("registration"))) {
//                map.get(answerAction).execute();
//                if (serviceLocator.getSessionService().getSession().getUser() != null) {
//                    User user = serviceLocator.getSessionService().getSession().getUser();
//                    authMenu(user);
//                } else {
//                    startMenu();
//                }
//            }
//        } else {
//            startMenu();
//        }
//    }
//
//    public void authMenu (User user) throws IOException, SQLException {
//        System.out.println("Выберите действие. Введите текст команды");
//            if (user.getRole().equals(UserRole.ADMIN)) {
//                for (Map.Entry<String, Action> e: map.entrySet()) {
//                    if (e.getValue().getRole() != ActionRole.GUEST) {
//                        System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
//                    }
//                }
//
//                String answerAction = reader.readLine();
//
//                for (Map.Entry<String, Action> pair: map.entrySet()) {
//                    if (pair.getKey().equals(answerAction) && pair.getValue().getRole() != ActionRole.GUEST) {
//                        pair.getValue().execute();
//                    }
//                }
//            } else {
//                for (Map.Entry<String, Action> e: map.entrySet()) {
//                    if (e.getValue().getRole() == ActionRole.USER) {
//                        System.out.println(e.getKey() + " : " + e.getValue().getDescription() );
//                    }
//                }
//
//                String answerAction = reader.readLine();
//
//                for (Map.Entry<String, Action> pair: map.entrySet()) {
//                    if (pair.getKey().equals(answerAction) && pair.getValue().getRole() != ActionRole.GUEST && pair.getValue().getRole() != ActionRole.ADMIN) {
//                        pair.getValue().execute();
//                    }
//                }
//            }
//
//            if (serviceLocator.getSessionService().getSession().getUser() != null) {
//                this.authMenu(user);
//            } else {
//                startMenu();
//            }
//    }
//}