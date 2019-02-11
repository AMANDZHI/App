package com.company.api;

import java.util.Map;

public interface CommonSerializationRepository<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    Map<T, M> readFileToObject(String path);
    void writeObjectToJson(String path, Map<T, M> map);
    void writeObjectToXml(String path, Map<T, M> map);
    Map<T, M> readJsonToObject(String path);
    Map<T, M> readXmlToObject(String path);
}