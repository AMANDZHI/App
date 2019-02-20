package com.company.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.company.api.SerializationWebServiceEndpoint;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-02-20T17:18:56.631+03:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "SerializationWebServiceEndpointImplService",
                  wsdlLocation = "http://localhost:1990/wss/serialization?wsdl",
                  targetNamespace = "http://endpoint.company.com/")
public class SerializationWebServiceEndpointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.company.com/", "SerializationWebServiceEndpointImplService");
    public final static QName SerializationWebServiceEndpointImplPort = new QName("http://endpoint.company.com/", "SerializationWebServiceEndpointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1990/wss/serialization?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SerializationWebServiceEndpointImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1990/wss/serialization?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SerializationWebServiceEndpointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SerializationWebServiceEndpointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SerializationWebServiceEndpointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SerializationWebServiceEndpointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SerializationWebServiceEndpointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SerializationWebServiceEndpointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SerializationWebServiceEndpoint
     */
    @WebEndpoint(name = "SerializationWebServiceEndpointImplPort")
    public SerializationWebServiceEndpoint getSerializationWebServiceEndpointImplPort() {
        return super.getPort(SerializationWebServiceEndpointImplPort, SerializationWebServiceEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SerializationWebServiceEndpoint
     */
    @WebEndpoint(name = "SerializationWebServiceEndpointImplPort")
    public SerializationWebServiceEndpoint getSerializationWebServiceEndpointImplPort(WebServiceFeature... features) {
        return super.getPort(SerializationWebServiceEndpointImplPort, SerializationWebServiceEndpoint.class, features);
    }

}
