package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Task;
import com.company.model.Task;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;
import java.util.Map;

public class TaskSerializationServiceImpl implements SerializationService<Task> {
    private CommonSerializationRepository commonSerializationRepository;

    public TaskSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToFile(path, list);
    }

    @Override
    public List<Task> readFileToObject(String path) {
        return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public void writeObjectToJson(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToJson(path, list);
    }

    @Override
    public void writeObjectToXml(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToXml(path, list);
    }

    @Override
    public List<Task> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }

    @Override
    public List<Task> readXmlToObject(String path) {
        return commonSerializationRepository.readXmlToObject(path);
    }
}