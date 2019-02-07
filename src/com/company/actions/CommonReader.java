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

    public static String getAdminUser() throws IOException {
        System.out.println("Введите true если хотите сделать юзера админом, или false если юзером");
        boolean f = true;
        String str = null;
        while(f) {
            str = reader.readLine();
            if (str.equals("true") || str.equals("false")) {
                f = false;
            } else {
                System.out.println("Введите true если хотите сделать юзера админом, или false если юзером");
            }
        }
        return str;
    }

    public static String getNewNameUser() throws IOException {
        System.out.println("Введите новое имя юзера");
        return reader.readLine();
    }

    public static String getNewLoginUser() throws IOException {
        System.out.println("Введите новый login юзера");
        return reader.readLine();
    }

    public static String getNewNamePassword() throws IOException {
        System.out.println("Введите новый password юзера");
        return reader.readLine();
    }
}