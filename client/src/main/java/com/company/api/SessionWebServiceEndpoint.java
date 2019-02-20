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
 * 2019-02-20T15:13:24.237+03:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://api.company.com/", name = "SessionWebServiceEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionWebServiceEndpoint {

    @WebMethod
    @Action(input = "http://api.company.com/SessionWebServiceEndpoint/openSessionRequest", output = "http://api.company.com/SessionWebServiceEndpoint/openSessionResponse")
    @RequestWrapper(localName = "openSession", targetNamespace = "http://api.company.com/", className = "com.company.api.OpenSession")
    @ResponseWrapper(localName = "openSessionResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.OpenSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.Session openSession(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://api.company.com/SessionWebServiceEndpoint/checkSessionRequest", output = "http://api.company.com/SessionWebServiceEndpoint/checkSessionResponse")
    @RequestWrapper(localName = "checkSession", targetNamespace = "http://api.company.com/", className = "com.company.api.CheckSession")
    @ResponseWrapper(localName = "checkSessionResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.CheckSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean checkSession(
        @WebParam(name = "arg0", targetNamespace = "")
        com.company.api.Session arg0
    );
}
