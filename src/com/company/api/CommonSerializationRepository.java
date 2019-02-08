package com.company.api;

import java.util.Map;

public interface CommonSerializationRepository<T, M> {
    void writeObjectToFile(String path, Map<T, M> map);
    Map<T, M> readFileToObject(String path);
}