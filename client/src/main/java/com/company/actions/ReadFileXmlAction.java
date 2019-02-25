package com.company.actions;

import com.company.ActionRole;
import com.company.api.SerializationWebServiceEndpoint;
import com.company.apiClient.Action;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadFileXmlAction implements Action {

    @Autowired
    private SerializationWebServiceEndpoint serializationWebServiceEndpoint;

    @Override
    public String getName() {
        return "readFileXmlToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization file Xml data to objects";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serializationWebServiceEndpoint.readXmlToObjects();
        System.out.println("Готово");
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}