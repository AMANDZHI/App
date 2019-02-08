package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSerializationRepositoryImpl implements CommonSerializationRepository<String, User> {

    @Override
    public Map<String, User> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<User> list = new ArrayList<>();
            list =((ArrayList<User>)objectInputStream.readObject());
            Map<String, User> map = new HashMap<>();
            for (User p: list) {
                map.put(p.getName(), p);
            }
            return map;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, User> map) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            List<User> list = new ArrayList<>();
            for (Map.Entry<String, User> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}