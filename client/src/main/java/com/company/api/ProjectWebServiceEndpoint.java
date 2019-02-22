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
 * 2019-02-22T16:21:39.089+03:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://api.company.com/", name = "ProjectWebServiceEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectWebServiceEndpoint {

    @WebMethod
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/saveProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/saveProjectResponse")
    @RequestWrapper(localName = "saveProject", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveProject")
    @ResponseWrapper(localName = "saveProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveProjectResponse")
    public void saveProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        com.company.api.Session arg2
    );

    @WebMethod
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/getListProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/getListProjectResponse")
    @RequestWrapper(localName = "getListProject", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListProject")
    @ResponseWrapper(localName = "getListProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.company.api.Project> getListProject(
        @WebParam(name = "arg0", targetNamespace = "")
        com.company.api.Session arg0
    );

    @WebMethod
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/updateProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/updateProjectResponse")
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateProjectResponse")
    public void updateProject(
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
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/findByIdProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/findByIdProjectResponse")
    @RequestWrapper(localName = "findByIdProject", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdProject")
    @ResponseWrapper(localName = "findByIdProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Project findByIdProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );

    @WebMethod
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/removeByNameProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/removeByNameProjectResponse")
    @RequestWrapper(localName = "removeByNameProject", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByNameProject")
    @ResponseWrapper(localName = "removeByNameProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByNameProjectResponse")
    public void removeByNameProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );

    @WebMethod
    @Action(input = "http://api.company.com/ProjectWebServiceEndpoint/findByNameProjectRequest", output = "http://api.company.com/ProjectWebServiceEndpoint/findByNameProjectResponse")
    @RequestWrapper(localName = "findByNameProject", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByNameProject")
    @ResponseWrapper(localName = "findByNameProjectResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByNameProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Project findByNameProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.company.api.Session arg1
    );
}
