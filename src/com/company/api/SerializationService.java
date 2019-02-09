package com.company.api;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public interface SerializationService<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    void writeObjectToJson(String path, Map<T, M> map) throws JsonMappingException;
    Map<T, M> readFileToObject(String path);
    Map<T, M> readJsonToObject(String path);
}