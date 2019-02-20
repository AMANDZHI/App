package com.company.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.company.api.UserWebServiceEndpoint;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-02-20T13:02:31.210+03:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "UserWebServiceEndpointImplService",
                  wsdlLocation = "http://localhost:1988/wss/user?wsdl",
                  targetNamespace = "http://endpoint.company.com/")
public class UserWebServiceEndpointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.company.com/", "UserWebServiceEndpointImplService");
    public final static QName UserWebServiceEndpointImplPort = new QName("http://endpoint.company.com/", "UserWebServiceEndpointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1988/wss/user?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserWebServiceEndpointImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1988/wss/user?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserWebServiceEndpointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserWebServiceEndpointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserWebServiceEndpointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UserWebServiceEndpointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UserWebServiceEndpointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UserWebServiceEndpointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UserWebServiceEndpoint
     */
    @WebEndpoint(name = "UserWebServiceEndpointImplPort")
    public UserWebServiceEndpoint getUserWebServiceEndpointImplPort() {
        return super.getPort(UserWebServiceEndpointImplPort, UserWebServiceEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserWebServiceEndpoint
     */
    @WebEndpoint(name = "UserWebServiceEndpointImplPort")
    public UserWebServiceEndpoint getUserWebServiceEndpointImplPort(WebServiceFeature... features) {
        return super.getPort(UserWebServiceEndpointImplPort, UserWebServiceEndpoint.class, features);
    }

}
