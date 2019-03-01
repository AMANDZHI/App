package com.company.api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-03-01T11:46:31.084+03:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://api.company.com/", name = "SerializationWebServiceEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SerializationWebServiceEndpoint {

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/writeObjectsToFilesRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/writeObjectsToFilesResponse")
    @RequestWrapper(localName = "writeObjectsToFiles", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteObjectsToFiles")
    @ResponseWrapper(localName = "writeObjectsToFilesResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteObjectsToFilesResponse")
    public void writeObjectsToFiles();

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/readJsonToObjectsRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/readJsonToObjectsResponse")
    @RequestWrapper(localName = "readJsonToObjects", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadJsonToObjects")
    @ResponseWrapper(localName = "readJsonToObjectsResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadJsonToObjectsResponse")
    public void readJsonToObjects();

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/readXmlToObjectsRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/readXmlToObjectsResponse")
    @RequestWrapper(localName = "readXmlToObjects", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadXmlToObjects")
    @ResponseWrapper(localName = "readXmlToObjectsResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadXmlToObjectsResponse")
    public void readXmlToObjects();

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/writeAllToJsonRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/writeAllToJsonResponse")
    @RequestWrapper(localName = "writeAllToJson", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteAllToJson")
    @ResponseWrapper(localName = "writeAllToJsonResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteAllToJsonResponse")
    public void writeAllToJson();

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/writeAllToXmlRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/writeAllToXmlResponse")
    @RequestWrapper(localName = "writeAllToXml", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteAllToXml")
    @ResponseWrapper(localName = "writeAllToXmlResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.WriteAllToXmlResponse")
    public void writeAllToXml();

    @WebMethod
    @Action(input = "http://api.company.com/SerializationWebServiceEndpoint/readFilesToObjectsRequest", output = "http://api.company.com/SerializationWebServiceEndpoint/readFilesToObjectsResponse")
    @RequestWrapper(localName = "readFilesToObjects", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadFilesToObjects")
    @ResponseWrapper(localName = "readFilesToObjectsResponse", targetNamespace = "http://api.company.com/", className = "com.company.api.ReadFilesToObjectsResponse")
    public void readFilesToObjects();
}
