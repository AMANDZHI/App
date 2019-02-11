package com.company.api;

import java.util.Map;

public interface SerializationService<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    void writeObjectToJson(String path, Map<T, M> map);
    void writeObjectToXml(String path, Map<T, M> map);
    Map<T, M> readFileToObject(String path);
    Map<T, M> readJsonToObject(String path);
    Map<T, M> readXmlToObject(String path);
}