package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Project;
import lombok.SneakyThrows;

import java.util.List;

public class ProjectSerializationServiceImpl implements SerializationService<Project> {
    private final CommonSerializationRepository commonSerializationRepository;

    public ProjectSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    @SneakyThrows
    public void writeObjectToFile(String path, List<Project> list) {
        commonSerializationRepository.writeObjectToFile(path, list);
    }

    @Override
    @SneakyThrows
    public List<Project> readFileToObject(String path) {
        return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    @SneakyThrows
    public void writeObjectToJson(String path, List<Project> list) {
        commonSerializationRepository.writeObjectToJson(path, list);
    }

    @Override
    @SneakyThrows
    public void writeObjectToXml(String path, List<Project> list) {
        commonSerializationRepository.writeObjectToXml(path, list);
    }

    @Override
    @SneakyThrows
    public List<Project> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }

    @Override
    @SneakyThrows
    public List<Project> readXmlToObject(String path) {
        return commonSerializationRepository.readXmlToObject(path);
    }
}