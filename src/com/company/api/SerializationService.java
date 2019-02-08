package com.company.api;

import java.util.Map;

public interface SerializationService<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    Map<T, M> readFileToObject(String path);
}