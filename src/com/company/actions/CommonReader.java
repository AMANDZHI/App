package com.company.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonReader {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getNameProject() throws IOException {
        System.out.println("Введите название проекта");
        return reader.readLine();
    }

    public static String getDescrProject() throws IOException {
        System.out.println("Введите описание проекта");
        return reader.readLine();
    }

    public static String getNewNameProject() throws IOException {
        System.out.println("Введите новое название проекта");
        return reader.readLine();
    }

    public static String getNewDescrProject() throws IOException {
        System.out.println("Введите новое описание проекта");
        return reader.readLine();
    }

    public static String getNameTask() throws IOException {
        System.out.println("Введите название таска");
        return reader.readLine();
    }

    public static String getDescrTask() throws IOException {
        System.out.println("Введите описание таска");
        return reader.readLine();
    }

    public static String getNewNameTask() throws IOException {
        System.out.println("Введите новое название таска");
        return reader.readLine();
    }

    public static String getNewDescrTask() throws IOException {
        System.out.println("Введите новое описание таска");
        return reader.readLine();
    }

    public static String getNewNameProjectTask() throws IOException {
        System.out.println("Введите имя другого проекта для этого таска");
        return reader.readLine();
    }

    public static String getNameUser() throws IOException {
        System.out.println("Введите имя юзера");
        return reader.readLine();
    }

    public static String getLoginUser() throws IOException {
        System.out.println("Введите login юзера");
        return reader.readLine();
    }

    public static String getPasswordUser() throws IOException {
        System.out.println("Введите password юзера");
        return reader.readLine();
    }

    public static String getRoleUser() throws IOException {
        System.out.println("Введите ADMIN если хотите сделать юзера админом, или USER если юзером");
        boolean f = true;
        String str = null;
        while(f) {
            str = reader.readLine();
            if (str.equals("ADMIN") || str.equals("USER")) {
                f = false;
            } else {
                System.out.println("Введите ADMIN если хотите сделать юзера админом, или USER если юзером");
            }
        }
        return str.toUpperCase();
    }

    public static String getNewNameUser() throws IOException {
        System.out.println("Введите новое имя юзера");
        return reader.readLine();
    }

    public static String getNewLoginUser() throws IOException {
        System.out.println("Введите новый login юзера");
        return reader.readLine();
    }

    public static String getNewPasswordUser() throws IOException {
        System.out.println("Введите новый password юзера");
        return reader.readLine();
    }

    public static String getNameFilePathForProjects() throws IOException {
        System.out.println("Введите путь к файлу для проектов");
        return reader.readLine();
    }

    public static String getNameFilePathForTasks() throws IOException {
        System.out.println("Введите путь к файлу для тасков");
        return reader.readLine();
    }

    public static String getNameFilePathForUsers() throws IOException {
        System.out.println("Введите путь к файлу для юзеров");
        return reader.readLine();
    }
}