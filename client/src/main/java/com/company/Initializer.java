//package com.company;
//
//import com.company.dao.ConnectionSupplier;
//import com.company.model.Project;
//import com.company.model.Task;
//import com.company.ui.Menu;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Initializer {
//    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private final Map<String, Action> map = new HashMap<>();
//    private final Menu menu = new Menu(reader, map);
//    private final List<Action> listForAction = new ArrayList<>();
//    private final CommonSerializationRepository commonSerializationRepository = new DomainSerializationRepositoryImpl();
//    private final SerializationService serializationService = new DomainSerializationServiceImpl(commonSerializationRepository);
//
//
//    public void run(Class[] classes) {
//        init(classes);
//        menu.startMenu();
//    }
//
//    private void init(Class[] classes) {
//        try {
//            for (Class aClass : classes) {
//                Action o = (Action) aClass.newInstance();
//                o.setServiceLocator(serviceLocator);
//                listForAction.add(o);
//            }
//
//            for (Action action: listForAction) {
//                map.put(action.getName(), action);
//            }
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//}