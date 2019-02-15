
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

    private final static QName _CheckSession_QNAME = new QName("http://api.company.com/", "checkSession");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://api.company.com/", "checkSessionResponse");
    private final static QName _OpenSession_QNAME = new QName("http://api.company.com/", "openSession");
    private final static QName _OpenSessionResponse_QNAME = new QName("http://api.company.com/", "openSessionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckSession }
     * 
     */
    public CheckSession createCheckSession() {
        return new CheckSession();
    }

    /**
     * Create an instance of {@link CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link OpenSession }
     * 
     */
    public OpenSession createOpenSession() {
        return new OpenSession();
    }

    /**
     * Create an instance of {@link OpenSessionResponse }
     * 
     */
    public OpenSessionResponse createOpenSessionResponse() {
        return new OpenSessionResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "checkSession")
    public JAXBElement<CheckSession> createCheckSession(CheckSession value) {
        return new JAXBElement<CheckSession>(_CheckSession_QNAME, CheckSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OpenSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "openSession")
    public JAXBElement<OpenSession> createOpenSession(OpenSession value) {
        return new JAXBElement<OpenSession>(_OpenSession_QNAME, OpenSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OpenSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.company.com/", name = "openSessionResponse")
    public JAXBElement<OpenSessionResponse> createOpenSessionResponse(OpenSessionResponse value) {
        return new JAXBElement<OpenSessionResponse>(_OpenSessionResponse_QNAME, OpenSessionResponse.class, null, value);
    }

}
