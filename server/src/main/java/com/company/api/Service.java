package com.company.api;

import java.util.List;
import java.util.Optional;

public interface Service<T, M> {
    M save(M object);
    Optional<M> findByName(T name);
    Optional<M> findById(T id);
    void update(M object);
    void removeByName(T name);
    List<M> getList();
}
