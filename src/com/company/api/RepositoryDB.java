package com.company.api;

import java.util.List;
import java.util.Optional;

public interface RepositoryDB<T, M> {
    boolean save(M object);
    Optional<M> findByName(T name);
    M update(M object);
    boolean removeByName(T name);
    List<M> getList();
}
