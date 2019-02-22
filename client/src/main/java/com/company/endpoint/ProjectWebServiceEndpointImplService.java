package com.company.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.company.api.ProjectWebServiceEndpoint;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2019-02-22T18:17:30.360+03:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "ProjectWebServiceEndpointImplService",
                  wsdlLocation = "http://localhost:1986/wss/project?wsdl",
                  targetNamespace = "http://endpoint.company.com/")
public class ProjectWebServiceEndpointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.company.com/", "ProjectWebServiceEndpointImplService");
    public final static QName ProjectWebServiceEndpointImplPort = new QName("http://endpoint.company.com/", "ProjectWebServiceEndpointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1986/wss/project?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProjectWebServiceEndpointImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1986/wss/project?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProjectWebServiceEndpointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProjectWebServiceEndpointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProjectWebServiceEndpointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ProjectWebServiceEndpointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ProjectWebServiceEndpointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ProjectWebServiceEndpointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ProjectWebServiceEndpoint
     */
    @WebEndpoint(name = "ProjectWebServiceEndpointImplPort")
    public ProjectWebServiceEndpoint getProjectWebServiceEndpointImplPort() {
        return super.getPort(ProjectWebServiceEndpointImplPort, ProjectWebServiceEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProjectWebServiceEndpoint
     */
    @WebEndpoint(name = "ProjectWebServiceEndpointImplPort")
    public ProjectWebServiceEndpoint getProjectWebServiceEndpointImplPort(WebServiceFeature... features) {
        return super.getPort(ProjectWebServiceEndpointImplPort, ProjectWebServiceEndpoint.class, features);
    }

}
