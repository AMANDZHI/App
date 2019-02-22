package com.company.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-02-22T17:17:26.099+03:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://api.company.com/", name = "TaskWebServiceEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskWebServiceEndpoint {

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/updateTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/updateTaskResponse")
    @RequestWrapper(localName = "updateTask", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateTask")
    @ResponseWrapper(localName = "updateTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateTaskResponse")
    public void updateTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        com.company.api.Session arg4
    );

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/removeByNameTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/removeByNameTaskResponse")
    @RequestWrapper(localName = "removeByNameTask", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByNameTask")
    @ResponseWrapper(localName = "removeByNameTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByNameTaskResponse")
    public void removeByNameTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/getListTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/getListTaskResponse")
    @RequestWrapper(localName = "getListTask", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListTask")
    @ResponseWrapper(localName = "getListTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.company.api.Task> getListTask(
        @WebParam(name = "arg0", targetNamespace = "")
        com.company.api.Session arg0
    );

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/saveTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/saveTaskResponse")
    @RequestWrapper(localName = "saveTask", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveTask")
    @ResponseWrapper(localName = "saveTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Task saveTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        com.company.api.Session arg3
    );

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/findByIdTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/findByIdTaskResponse")
    @RequestWrapper(localName = "findByIdTask", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdTask")
    @ResponseWrapper(localName = "findByIdTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Task findByIdTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );

    @WebMethod
    @Action(input = "http://api.company.com/TaskWebServiceEndpoint/findByNameTaskRequest", output = "http://api.company.com/TaskWebServiceEndpoint/findByNameTaskResponse")
    @RequestWrapper(localName = "findByNameTask", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByNameTask")
    @ResponseWrapper(localName = "findByNameTaskResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByNameTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Task findByNameTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );
}
