package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskSerializationRepositoryImpl implements CommonSerializationRepository<Task> {

    @Override
    @SneakyThrows
    public List<Task> readFileToObject(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Task> list = new ArrayList<>();
            list = ((ArrayList<Task>) objectInputStream.readObject());
            return list;
        }
    }

    @Override
    @SneakyThrows
    public void writeObjectToJson(String path, List<Task> list) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileOutputStream(path), list);

    }

    @Override
    @SneakyThrows
    public void writeObjectToXml(String path, List<Task> list) {
        ObjectMapper mapper = new XmlMapper();
        mapper.writeValue(new File(path), list);
    }

    @Override
    @SneakyThrows
    public List<Task> readJsonToObject(String path) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileInputStream(path), new TypeReference<List<Task>>(){});
    }

    @Override
    @SneakyThrows
    public List<Task> readXmlToObject(String path) {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(new File(path), new TypeReference<List<Task>>(){});
    }

    @Override
    @SneakyThrows
    public void writeObjectToFile(String path, List<Task> list) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        }
    }
}