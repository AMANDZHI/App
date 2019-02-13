package com.company.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RepositoryDB<T, M> {
    boolean save(M object) throws IOException, SQLException;
    Optional<M> findByName(T name) throws IOException, SQLException;
    Optional<M> findById(T id) throws IOException, SQLException;
    boolean update(M object) throws IOException, SQLException;
    boolean removeByName(T name) throws IOException, SQLException;
    List<M> getList() throws IOException, SQLException;
}
