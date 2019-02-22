package com.company.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.company.api.SessionWebServiceEndpoint;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-02-22T18:17:30.677+03:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "SessionWebServiceEndpointImplService",
                  wsdlLocation = "http://localhost:1989/wss/session?wsdl",
                  targetNamespace = "http://endpoint.company.com/")
public class SessionWebServiceEndpointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.company.com/", "SessionWebServiceEndpointImplService");
    public final static QName SessionWebServiceEndpointImplPort = new QName("http://endpoint.company.com/", "SessionWebServiceEndpointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1989/wss/session?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SessionWebServiceEndpointImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1989/wss/session?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SessionWebServiceEndpointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SessionWebServiceEndpointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SessionWebServiceEndpointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SessionWebServiceEndpointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SessionWebServiceEndpointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SessionWebServiceEndpointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SessionWebServiceEndpoint
     */
    @WebEndpoint(name = "SessionWebServiceEndpointImplPort")
    public SessionWebServiceEndpoint getSessionWebServiceEndpointImplPort() {
        return super.getPort(SessionWebServiceEndpointImplPort, SessionWebServiceEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SessionWebServiceEndpoint
     */
    @WebEndpoint(name = "SessionWebServiceEndpointImplPort")
    public SessionWebServiceEndpoint getSessionWebServiceEndpointImplPort(WebServiceFeature... features) {
        return super.getPort(SessionWebServiceEndpointImplPort, SessionWebServiceEndpoint.class, features);
    }

}
