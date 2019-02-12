package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectSerializationRepositoryImpl implements CommonSerializationRepository<Project> {

    @Override
    public List<Project> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Project> list = new ArrayList<>();
            list =((ArrayList<Project>)objectInputStream.readObject());
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToJson(String path, List<Project> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), list);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectToXml(String path, List<Project> list) {
        try {
            ObjectMapper mapper = new XmlMapper();
            mapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> readJsonToObject(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(path), new TypeReference<List<Project>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Project> readXmlToObject(String path) {
        try {
            ObjectMapper mapper = new XmlMapper();
            return mapper.readValue(new File(path), new TypeReference<List<Project>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeObjectToFile(String path, List<Project> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}