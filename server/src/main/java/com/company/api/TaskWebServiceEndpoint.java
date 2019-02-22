package com.company.api;

import com.company.model.Session;
import com.company.model.Task;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface TaskWebServiceEndpoint {

    Task saveTask(String nameTask, String descriptionTask, String nameProject , Session session);

    Task findByNameTask(String name, Session session);

    Task findByIdTask(String id, Session session);

    void updateTask(String name, String newNameTask, String newDescriptionTask, String newNameProject, Session session);

    void removeByNameTask(String name, Session session);

    List<Task> getListTask(Session session);
}
