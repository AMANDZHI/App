package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Task;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.SneakyThrows;

import java.util.List;

public class TaskSerializationServiceImpl implements SerializationService<Task> {
    private final CommonSerializationRepository commonSerializationRepository;

    public TaskSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    @SneakyThrows
    public void writeObjectToFile(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToFile(path, list);
    }

    @Override
    @SneakyThrows
    public List<Task> readFileToObject(String path) {
        return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    @SneakyThrows
    public void writeObjectToJson(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToJson(path, list);
    }

    @Override
    @SneakyThrows
    public void writeObjectToXml(String path, List<Task> list) {
        commonSerializationRepository.writeObjectToXml(path, list);
    }

    @Override
    @SneakyThrows
    public List<Task> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }

    @Override
    @SneakyThrows
    public List<Task> readXmlToObject(String path) {
        return commonSerializationRepository.readXmlToObject(path);
    }
}