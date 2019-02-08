package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.User;

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
    public Map<String, User> readFileToObject(String path) {
       return commonSerializationRepository.readFileToObject(path);
    }
}
