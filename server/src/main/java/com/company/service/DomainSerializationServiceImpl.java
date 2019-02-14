package com.company.service;

import com.company.api.CommonSerializationRepository;
import com.company.api.SerializationService;
import com.company.model.Domain;

import java.util.List;

public class DomainSerializationServiceImpl implements SerializationService {
    private CommonSerializationRepository commonSerializationRepository;

    public DomainSerializationServiceImpl(CommonSerializationRepository commonSerializationRepository) {
        this.commonSerializationRepository = commonSerializationRepository;
    }

    @Override
    public void writeObjectToFile(String path, List list) {
        commonSerializationRepository.writeObjectToFile(path, list);
    }

    @Override
    public List readFileToObject(String path) {
        return commonSerializationRepository.readFileToObject(path);
    }

    @Override
    public void writeAllToJson(String path, Domain domain) {
        commonSerializationRepository.writeAllToJson(path, domain);
    }

    @Override
    public void writeAllToXml(String path, Domain domain) {
        commonSerializationRepository.writeAllToXml(path, domain);
    }

    @Override
    public Domain readJsonToObjects(String path) {
        return commonSerializationRepository.readJsonToObjects(path);
    }

    @Override
    public Domain readXmlToObjects(String path) {
        return commonSerializationRepository.readXmlToObjects(path);
    }
}
