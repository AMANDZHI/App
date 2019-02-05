package com.company.service;

import java.util.List;

public interface Service<T> {
    void save(T object);
    T findById(Integer id);
    T update(T object);
    boolean removeById(Integer id);
    List<T> getList();
}