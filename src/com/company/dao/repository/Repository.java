package com.company.dao.repository;

import java.util.List;

public interface Repository<T> {
    void save(T object);
    T findById(Integer id);
    T update(T object);
    boolean removeById(Integer id);
    List<T> getList();
}
