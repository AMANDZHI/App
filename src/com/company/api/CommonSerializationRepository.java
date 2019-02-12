package com.company.api;

import java.util.List;

public interface CommonSerializationRepository<T> {
    void writeObjectToFile(String path, List<T> list);
    List<T> readFileToObject(String path);
    void writeObjectToJson(String path, List<T> list);
    void writeObjectToXml(String path, List<T> list);
    List<T> readJsonToObject(String path);
    List<T> readXmlToObject(String path);
}