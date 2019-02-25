package com.company.actions;

import com.company.ActionRole;
import com.company.api.SerializationWebServiceEndpoint;
import com.company.apiClient.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WriteAllToFilesJsonAction implements Action {

    @Autowired
    private SerializationWebServiceEndpoint serializationWebServiceEndpoint;

    @Override
    public String getName() {
        return "writeAllToFileJson";
    }

    @Override
    public String getDescription() {
        return "serialization all data to json";
    }

    @Override
    public void execute() {
        serializationWebServiceEndpoint.writeAllToJson();
        System.out.println("Готово");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}