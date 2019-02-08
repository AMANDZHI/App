package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Task;

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
    public Map<String, Task> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }
}
