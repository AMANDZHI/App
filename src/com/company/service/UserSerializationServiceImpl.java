package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.User;

import java.util.List;

public class UserSerializationServiceImpl implements SerializationService<User> {
    private CommonSerializationRepository commonSerializationRepository;

    public UserSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, List<User> list) {
        commonSerializationRepository.writeObjectToFile(path, list);
    }

    @Override
    public List<User> readFileToObject(String path) {
        return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public void writeObjectToJson(String path, List<User> list) {
        commonSerializationRepository.writeObjectToJson(path, list);
    }

    @Override
    public void writeObjectToXml(String path, List<User> list) {
        commonSerializationRepository.writeObjectToXml(path, list);
    }

    @Override
    public List<User> readJsonToObject(String path) {
        return commonSerializationRepository.readJsonToObject(path);
    }

    @Override
    public List<User> readXmlToObject(String path) {
        return commonSerializationRepository.readXmlToObject(path);
    }
}
