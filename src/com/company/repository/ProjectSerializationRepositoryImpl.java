package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
    public void writeObjectToJson(String path, Map<String, Project> map) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Project> list = new ArrayList<>();
            for (Map.Entry<String, Project> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            mapper.writeValue(new File(path), list);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectToXml(String path, Map<String, Project> map) {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<Project> list = new ArrayList<>();
            for (Map.Entry<String, Project> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            mapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Project> readJsonToObject(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Project> list = mapper.readValue(new File(path), new TypeReference<List<Project>>(){});

            Map<String, Project> map = new HashMap<>();
            for (Project p: list) {
                map.put(p.getId(), p);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Project> readXmlToObject(String path) {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<Project> list = mapper.readValue(new File(path), new TypeReference<List<Project>>(){});

            Map<String, Project> map = new HashMap<>();
            for (Project p: list) {
                map.put(p.getId(), p);
            }
            return map;
        } catch (IOException e) {
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