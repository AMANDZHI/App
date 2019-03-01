
package com.company.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.company.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReadFilesToObjects_QNAME = new QName("http://api.company.com/", "readFilesToObjects");
    private final static QName _ReadFilesToObjectsResponse_QNAME = new QName("http://api.company.com/", "readFilesToObjectsResponse");
    private final static QName _ReadJsonToObjects_QNAME = new QName("http://api.company.com/", "readJsonToObjects");
    private final static QName _ReadJsonToObjectsResponse_QNAME = new QName("http://api.company.com/", "readJsonToObjectsResponse");
    private final static QName _ReadXmlToObjects_QNAME = new QName("http://api.company.com/", "readXmlToObjects");
    private final static QName _ReadXmlToObjectsResponse_QNAME = new QName("http://api.company.com/", "readXmlToObjectsResponse");
    private final static QName _WriteAllToJson_QNAME = new QName("http://api.company.com/", "writeAllToJson");
    private final static QName _WriteAllToJsonResponse_QNAME = new QName("http://api.company.com/", "writeAllToJsonResponse");
    private final static QName _WriteAllToXml_QNAME = new QName("http://api.company.com/", "writeAllToXml");
    private final static QName _WriteAllToXmlResponse_QNAME = new QName("http://api.company.com/", "writeAllToXmlResponse");
    private final static QName _WriteObjectsToFiles_QNAME = new QName("http://api.company.com/", "writeObjectsToFiles");
    private final static QName _WriteObjectsToFilesResponse_QNAME = new QName("http://api.company.com/", "writeObjectsToFilesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadFilesToObjects }
     * 
     */
    public ReadFilesToObjects createReadFilesToObjects() {
        return new ReadFilesToObjects();
    }

    /**
     * Create an instance of {@link ReadFilesToObjectsResponse }
     * 
     */
    public ReadFilesToObjectsResponse createReadFilesToObjectsResponse() {
        return new ReadFilesToObjectsResponse();
    }

    /**
     * Create an instance of {@link ReadJsonToObjects }
     * 
     */
    public ReadJsonToObjects createReadJsonToObjects() {
        return new ReadJsonToObjects();
    }

    /**
     * Create an instance of {@link ReadJsonToObjectsResponse }
     * 
     */
    public ReadJsonToObjectsResponse createReadJsonToObjectsResponse() {
        return new ReadJsonToObjectsResponse();
    }

    /**
     * Create an instance of {@link ReadXmlToObjects }
     * 
     */
    public ReadXmlToObjects createReadXmlToObjects() {
        return new ReadXmlToObjects();
    }

    /**
     * Create an instance of {@link ReadXmlToObjectsResponse }
     * 
     */
    public ReadXmlToObjectsResponse createReadXmlToObjectsResponse() {
        return new ReadXmlToObjectsResponse();
    }

    /**
     * Create an instance of {@link WriteAllToJson }
     * 
     */
    public WriteAllToJson createWriteAllToJson() {
        return new WriteAllToJson();
    }

    /**
     * Create an instance of {@link WriteAllToJsonResponse }
     * 
     */
    public WriteAllToJsonResponse createWriteAllToJsonResponse() {
        return new WriteAllToJsonResponse();
    }

    /**
     * Create an instance of {@link WriteAllToXml }
     * 
     */
    public WriteAllToXml createWriteAllToXml() {
        return new WriteAllToXml();
    }

    /**
     * Create an instance of {@link WriteAllToXmlResponse }
     * 
     */
    public WriteAllToXmlResponse createWriteAllToXmlResponse() {
        return new WriteAllToXmlResponse();
    }

    /**
     * Create an instance of {@link WriteObjectsToFiles }
     * 
     */
    public WriteObjectsToFiles createWriteObjectsToFiles() {
        return new WriteObjectsToFiles();
    }

    /**
     * Create an instance of {@link WriteObjectsToFilesResponse }
     * 
     */
    public WriteObjectsToFilesResponse createWriteObjectsToFilesResponse() {
        return new WriteObjectsToFilesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFilesToObjects }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadFilesToObjects }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readFilesToObjects")
    public JAXBElement<ReadFilesToObjects> createReadFilesToObjects(ReadFilesToObjects value) {
        return new JAXBElement<ReadFilesToObjects>(_ReadFilesToObjects_QNAME, ReadFilesToObjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadFilesToObjectsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadFilesToObjectsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readFilesToObjectsResponse")
    public JAXBElement<ReadFilesToObjectsResponse> createReadFilesToObjectsResponse(ReadFilesToObjectsResponse value) {
        return new JAXBElement<ReadFilesToObjectsResponse>(_ReadFilesToObjectsResponse_QNAME, ReadFilesToObjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadJsonToObjects }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadJsonToObjects }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readJsonToObjects")
    public JAXBElement<ReadJsonToObjects> createReadJsonToObjects(ReadJsonToObjects value) {
        return new JAXBElement<ReadJsonToObjects>(_ReadJsonToObjects_QNAME, ReadJsonToObjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadJsonToObjectsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadJsonToObjectsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readJsonToObjectsResponse")
    public JAXBElement<ReadJsonToObjectsResponse> createReadJsonToObjectsResponse(ReadJsonToObjectsResponse value) {
        return new JAXBElement<ReadJsonToObjectsResponse>(_ReadJsonToObjectsResponse_QNAME, ReadJsonToObjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadXmlToObjects }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadXmlToObjects }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readXmlToObjects")
    public JAXBElement<ReadXmlToObjects> createReadXmlToObjects(ReadXmlToObjects value) {
        return new JAXBElement<ReadXmlToObjects>(_ReadXmlToObjects_QNAME, ReadXmlToObjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadXmlToObjectsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadXmlToObjectsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "readXmlToObjectsResponse")
    public JAXBElement<ReadXmlToObjectsResponse> createReadXmlToObjectsResponse(ReadXmlToObjectsResponse value) {
        return new JAXBElement<ReadXmlToObjectsResponse>(_ReadXmlToObjectsResponse_QNAME, ReadXmlToObjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAllToJson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteAllToJson }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeAllToJson")
    public JAXBElement<WriteAllToJson> createWriteAllToJson(WriteAllToJson value) {
        return new JAXBElement<WriteAllToJson>(_WriteAllToJson_QNAME, WriteAllToJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAllToJsonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteAllToJsonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeAllToJsonResponse")
    public JAXBElement<WriteAllToJsonResponse> createWriteAllToJsonResponse(WriteAllToJsonResponse value) {
        return new JAXBElement<WriteAllToJsonResponse>(_WriteAllToJsonResponse_QNAME, WriteAllToJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAllToXml }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteAllToXml }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeAllToXml")
    public JAXBElement<WriteAllToXml> createWriteAllToXml(WriteAllToXml value) {
        return new JAXBElement<WriteAllToXml>(_WriteAllToXml_QNAME, WriteAllToXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAllToXmlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteAllToXmlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeAllToXmlResponse")
    public JAXBElement<WriteAllToXmlResponse> createWriteAllToXmlResponse(WriteAllToXmlResponse value) {
        return new JAXBElement<WriteAllToXmlResponse>(_WriteAllToXmlResponse_QNAME, WriteAllToXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteObjectsToFiles }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteObjectsToFiles }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeObjectsToFiles")
    public JAXBElement<WriteObjectsToFiles> createWriteObjectsToFiles(WriteObjectsToFiles value) {
        return new JAXBElement<WriteObjectsToFiles>(_WriteObjectsToFiles_QNAME, WriteObjectsToFiles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteObjectsToFilesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteObjectsToFilesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "writeObjectsToFilesResponse")
    public JAXBElement<WriteObjectsToFilesResponse> createWriteObjectsToFilesResponse(WriteObjectsToFilesResponse value) {
        return new JAXBElement<WriteObjectsToFilesResponse>(_WriteObjectsToFilesResponse_QNAME, WriteObjectsToFilesResponse.class, null, value);
    }

}
