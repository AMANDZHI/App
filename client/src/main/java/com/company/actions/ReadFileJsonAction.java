package com.company.actions;

import com.company.ActionRole;
import com.company.api.SerializationWebServiceEndpoint;
import com.company.apiClient.Action;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadFileJsonAction implements Action {

    @Autowired
    private SerializationWebServiceEndpoint serializationWebServiceEndpoint;

    @Override
    public String getName() {
        return "readFileJsonToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization file json data to objects";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serializationWebServiceEndpoint.readJsonToObjects();
        System.out.println("Готово");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}