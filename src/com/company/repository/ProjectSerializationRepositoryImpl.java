package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Project;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectSerializationRepositoryImpl implements CommonSerializationRepository<String, Project> {

    @Override
    public Map<String, Project> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Project> list = new ArrayList<>();
            list =((ArrayList<Project>)objectInputStream.readObject());
            Map<String, Project> map = new HashMap<>();
            for (Project p: list) {
                map.put(p.getName(), p);
            }
            return map;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, Project> map) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            List<Project> list = new ArrayList<>();
            for (Map.Entry<String, Project> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
