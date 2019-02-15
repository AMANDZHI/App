package com.company.endpoint;

import com.company.api.ServiceDB;
import com.company.model.Task;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TaskServiceEndpoint {
    private final ServiceDB<String, Task> taskServiceDB;

    public TaskServiceEndpoint(ServiceDB<String, Task> taskServiceDB) {
        this.taskServiceDB = taskServiceDB;
    }

    public boolean save(Task object) throws IOException, SQLException {
        return taskServiceDB.save(object);
    }

    @SneakyThrows
    public Optional<Task> findByName(String name) {
        return taskServiceDB.findByName(name);
    }

    @SneakyThrows
    public Optional<Task> findById(String id) {
        return taskServiceDB.findById(id);
    }

    @SneakyThrows
    public boolean update(Task object) {
        return taskServiceDB.update(object);
    }

    @SneakyThrows
    public boolean removeByName(String name) {
        return taskServiceDB.removeByName(name);
    }

    @SneakyThrows
    public List<Task> getList() {
        return taskServiceDB.getList();
    }
}