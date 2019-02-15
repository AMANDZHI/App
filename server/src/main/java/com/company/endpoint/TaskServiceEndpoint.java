package com.company.endpoint;

import com.company.api.ServiceDB;
import com.company.model.Task;
import lombok.SneakyThrows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public class TaskServiceEndpoint {
    private final ServiceDB<String, Task> taskServiceDB;

    public TaskServiceEndpoint(ServiceDB<String, Task> taskServiceDB) {
        this.taskServiceDB = taskServiceDB;
    }

    @WebMethod
    public boolean save(@WebParam(name="task") Task object) {
        return taskServiceDB.save(object);
    }

    @WebMethod
    @SneakyThrows
    public Optional<Task> findByName(@WebParam(name="task_name") String name) {
        return taskServiceDB.findByName(name);
    }

    @WebMethod
    @SneakyThrows
    public Optional<Task> findById(@WebParam(name="task_id") String id) {
        return taskServiceDB.findById(id);
    }

    @WebMethod
    @SneakyThrows
    public boolean update(@WebParam(name="task") Task object) {
        return taskServiceDB.update(object);
    }

    @WebMethod
    @SneakyThrows
    public boolean removeByName(@WebParam(name="task_name") String name) {
        return taskServiceDB.removeByName(name);
    }

    @WebMethod
    @SneakyThrows
    public List<Task> getList() {
        return taskServiceDB.getList();
    }
}