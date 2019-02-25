package com.company.actions;

import com.company.ActionRole;
import com.company.api.SerializationWebServiceEndpoint;
import com.company.apiClient.Action;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WriteAllToFilesTxtAction implements Action {

    @Autowired
    private SerializationWebServiceEndpoint serializationWebServiceEndpoint;

    @Override
    public String getName() {
        return "writeAllToFilesTxt";
    }

    @Override
    public String getDescription() {
        return "serialization all data to txt";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serializationWebServiceEndpoint.writeObjectsToFiles();
        System.out.println("Готово");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}