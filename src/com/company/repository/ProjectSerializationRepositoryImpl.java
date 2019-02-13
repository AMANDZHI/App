package com.company.repository;

import com.company.api.CommonSerializationRepository;
import com.company.model.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectSerializationRepositoryImpl implements CommonSerializationRepository<Project> {

    @Override
    @SneakyThrows
    public List<Project> readFileToObject(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<Project> list = new ArrayList<>();
            list = ((ArrayList<Project>) objectInputStream.readObject());
            return list;
        }
    }

    @Override
    @SneakyThrows
    public void writeObjectToJson(String path, List<Project> list) {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        mapper.writeValue(new File(path), s);
    }

    @Override
    @SneakyThrows
    public void writeObjectToXml(String path, List<Project> list) {
        ObjectMapper mapper = new XmlMapper();
        mapper.writeValue(new File(path), list);
    }

    @Override
    @SneakyThrows
    public List<Project> readJsonToObject(String path){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<Project>>(){});
    }

    @Override
    @SneakyThrows
    public List<Project> readXmlToObject(String path) {
            ObjectMapper mapper = new XmlMapper();
            return mapper.readValue(new File(path), new TypeReference<List<Project>>(){});
    }

    @Override
    @SneakyThrows
    public void writeObjectToFile(String path, List<Project> list) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        }
    }
}