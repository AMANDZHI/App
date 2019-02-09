package com.company.api;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public interface CommonSerializationRepository<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    Map<T, M> readFileToObject(String path);
    void writeObjectToJson(String path, Map<T, M> map) throws JsonMappingException;
    Map<T, M> readJsonToObject(String path);
}