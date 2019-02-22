package com.company.api;

import java.util.List;
import java.util.Optional;

public interface Repository<T, M> {
    void save(M object);
    Optional<M> findByName(T name);
    Optional<M> findById(T id);
    M update(M object);
    void removeByName(T name);
    List<M> getList();
}