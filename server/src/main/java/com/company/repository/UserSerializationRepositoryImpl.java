package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSerializationRepositoryImpl implements CommonSerializationRepository<User> {

    @Override
    @SneakyThrows
    public List<User> readFileToObject(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<User> list = new ArrayList<>();
            list =((ArrayList<User>)objectInputStream.readObject());
            return list;
        }
    }

    @Override
    @SneakyThrows
    public void writeObjectToJson(String path, List<User> list) {
        ObjectMapper mapper = new ObjectMapper();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(fileOutputStream, list);
    }

    @Override
    @SneakyThrows
    public void writeObjectToXml(String path, List<User> list) {
        ObjectMapper mapper = new XmlMapper();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(fileOutputStream, list);
    }

    @Override
    @SneakyThrows
    public List<User> readJsonToObject(String path) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileInputStream(path), new TypeReference<List<User>>(){});
    }

    @Override
    @SneakyThrows
    public List<User> readXmlToObject(String path) {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(new File(path), new TypeReference<List<User>>(){});
    }

    @Override
    @SneakyThrows
    public void writeObjectToFile(String path, List<User> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        }
    }
}