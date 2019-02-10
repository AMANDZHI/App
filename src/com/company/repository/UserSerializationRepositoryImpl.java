package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
    public void writeObjectToJson(String path, Map<String, User> map) throws JsonMappingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<User> list = new ArrayList<>();
            for (Map.Entry<String, User> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            mapper.writeValue(new FileOutputStream(path), list);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectToXml(String path, Map<String, User> map) {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<User> list = new ArrayList<>();
            for (Map.Entry<String, User> pair: map.entrySet()) {
                list.add(pair.getValue());
            }
            mapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, User> readJsonToObject(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<User> list = mapper.readValue(new FileInputStream(path), new TypeReference<List<User>>(){});

            Map<String, User> map = new HashMap<>();
            for (User u: list) {
                map.put(u.getId(), u);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, User> readXmlToObject(String path) {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<User> list = mapper.readValue(new File(path), new TypeReference<List<User>>(){});

            Map<String, User> map = new HashMap<>();
            for (User u: list) {
                map.put(u.getId(), u);
            }
            return map;
        } catch (IOException e) {
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