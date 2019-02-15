package com.company.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServiceDB<T, M> {
    boolean save(M object);
    Optional<M> findByName(T name);
    Optional<M> findById(T id);
    boolean update(M object);
    boolean removeByName(T name);
    List<M> getList();
}
