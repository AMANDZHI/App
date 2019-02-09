package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Project;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public class ProjectSerializationServiceImpl implements SerializationService<String, Project> {
    private CommonSerializationRepository commonSerializationRepository;

    public ProjectSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, Project> map) {
        commonSerializationRepository.writeObjectToFile(path, map);
    }

    @Override
    public void writeObjectToJson(String path, Map<String, Project> map) throws JsonMappingException {
        commonSerializationRepository.writeObjectToJson(path, map);
    }

    @Override
    public Map<String, Project> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public Map<String, Project> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }
}
