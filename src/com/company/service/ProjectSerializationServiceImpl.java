package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Project;

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
    public Map<String, Project> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }
}
