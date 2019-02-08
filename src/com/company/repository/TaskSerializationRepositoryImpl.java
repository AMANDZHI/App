package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSerializationRepositoryImpl implements CommonSerializationRepository<String, Task> {

    @Override
    public Map<String, Task> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Task> list = new ArrayList<>();
            list =((ArrayList<Task>)objectInputStream.readObject());
            Map<String, Task> map = new HashMap<>();
            for (Task t: list) {
                map.put(t.getName(), t);
            }
            return map;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, Task> map) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            List<Task> list = new ArrayList<>();
            for (Map.Entry<String, Task> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
