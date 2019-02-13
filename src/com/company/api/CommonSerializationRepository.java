package com.company.api;

import java.io.IOException;
import java.util.List;

public interface CommonSerializationRepository<T> {
    void writeObjectToFile(String path, List<T> list) throws IOException;
    List<T> readFileToObject(String path) throws IOException, ClassNotFoundException;
    void writeObjectToJson(String path, List<T> list) throws IOException;
    void writeObjectToXml(String path, List<T> list) throws IOException;
    List<T> readJsonToObject(String path) throws IOException;
    List<T> readXmlToObject(String path) throws IOException;
}