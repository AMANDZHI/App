package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Task;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public class TaskSerializationServiceImpl implements SerializationService<String, Task> {
    private CommonSerializationRepository commonSerializationRepository;

    public TaskSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, Task> map) {
        commonSerializationRepository.writeObjectToFile(path, map);
    }

    @Override
    public void writeObjectToJson(String path, Map<String, Task> map) {
        commonSerializationRepository.writeObjectToJson(path, map);
    }

    @Override
    public void writeObjectToXml(String path, Map<String, Task> map) {
        commonSerializationRepository.writeObjectToXml(path, map);
    }

    @Override
    public Map<String, Task> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public Map<String, Task> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }

    @Override
    public Map<String, Task> readXmlToObject(String path) {
        return commonSerializationRepository.readXmlToObject(path);
    }
}