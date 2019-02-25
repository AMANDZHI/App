package com.company.actions;

import com.company.ActionRole;
import com.company.api.SerializationWebServiceEndpoint;
import com.company.apiClient.Action;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadFilesTxtAction implements Action {

    @Autowired
    private SerializationWebServiceEndpoint serializationWebServiceEndpoint;

    @Override
    public String getName() {
        return "readFilesTxtToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization txt data to objects";
    }

    @Override
    @SneakyThrows
    public  void execute() {
        serializationWebServiceEndpoint.readFilesToObjects();
        System.out.println("Готово");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}
