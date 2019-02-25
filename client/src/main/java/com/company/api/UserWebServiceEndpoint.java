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
 * 2019-02-25T17:02:22.214+03:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://api.company.com/", name = "UserWebServiceEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserWebServiceEndpoint {

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/getListUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/getListUserResponse")
    @RequestWrapper(localName = "getListUser", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListUser")
    @ResponseWrapper(localName = "getListUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.GetListUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.company.api.User> getListUser(
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/removeByLoginUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/removeByLoginUserResponse")
    @RequestWrapper(localName = "removeByLoginUser", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByLoginUser")
    @ResponseWrapper(localName = "removeByLoginUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.RemoveByLoginUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean removeByLoginUser(
        @WebParam(name = "user_login", targetNamespace = "")
        java.lang.String userLogin,
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/updateUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/updateUserResponse")
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.User updateUser(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "newName", targetNamespace = "")
        java.lang.String newName,
        @WebParam(name = "newLogin", targetNamespace = "")
        java.lang.String newLogin,
        @WebParam(name = "newPassword", targetNamespace = "")
        java.lang.String newPassword,
        @WebParam(name = "newRole", targetNamespace = "")
        java.lang.String newRole,
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/findByLoginUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/findByLoginUserResponse")
    @RequestWrapper(localName = "findByLoginUser", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByLoginUser")
    @ResponseWrapper(localName = "findByLoginUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByLoginUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.User findByLoginUser(
        @WebParam(name = "user_login", targetNamespace = "")
        java.lang.String userLogin,
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/saveUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/saveUserResponse")
    @RequestWrapper(localName = "saveUser", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveUser")
    @ResponseWrapper(localName = "saveUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.SaveUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.User saveUser(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role,
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );

    @WebMethod
    @Action(input = "http://api.company.com/UserWebServiceEndpoint/findByIdUserRequest", output = "http://api.company.com/UserWebServiceEndpoint/findByIdUserResponse")
    @RequestWrapper(localName = "findByIdUser", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdUser")
    @ResponseWrapper(localName = "findByIdUserResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.FindByIdUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.company.api.User findByIdUser(
        @WebParam(name = "user_id", targetNamespace = "")
        java.lang.String userId,
        @WebParam(name = "session", targetNamespace = "")
        com.company.api.Session session
    );
}
