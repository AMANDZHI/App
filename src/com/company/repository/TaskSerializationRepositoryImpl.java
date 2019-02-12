package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskSerializationRepositoryImpl implements CommonSerializationRepository<Task> {

    @Override
    public List<Task> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Task> list = new ArrayList<>();
            list =((ArrayList<Task>)objectInputStream.readObject());
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToJson(String path, List<Task> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new FileOutputStream(path), list);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectToXml(String path, List<Task> list) {
        try {
            ObjectMapper mapper = new XmlMapper();
            mapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> readJsonToObject(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream(path), new TypeReference<List<Task>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> readXmlToObject(String path) {
        try {
            ObjectMapper mapper = new XmlMapper();
            return mapper.readValue(new File(path), new TypeReference<List<Task>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToFile(String path, List<Task> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}