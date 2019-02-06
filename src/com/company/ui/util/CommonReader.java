package com.company.ui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonReader {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getIdProject() throws IOException {
        System.out.println("Введите id проекта");
        return reader.readLine();
    }

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

    public static String getIdTask() throws IOException {
        System.out.println("Введите id таска");
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

    public static String getNewProjectTask() throws IOException {
        System.out.println("Введите новый id проекта");
        return reader.readLine();
    }
}