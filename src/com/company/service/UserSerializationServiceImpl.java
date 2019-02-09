package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.User;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public class UserSerializationServiceImpl implements SerializationService<String, User> {
    private CommonSerializationRepository commonSerializationRepository;

    public UserSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, Map<String, User> map) {
        commonSerializationRepository.writeObjectToFile(path, map);
    }

    @Override
    public void writeObjectToJson(String path, Map<String, User> map) throws JsonMappingException {
        commonSerializationRepository.writeObjectToJson(path, map);
    }

    @Override
    public Map<String, User> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public Map<String, User> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }
}
