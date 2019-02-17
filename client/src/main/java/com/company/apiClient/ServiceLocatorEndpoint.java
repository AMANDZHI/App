package com.company.apiClient;

import com.company.api.*;
import com.company.service.ClientSessionService;

public interface ServiceLocatorEndpoint {
    SessionWebServiceEndpoint getSessionWebService();
    ProjectWebServiceEndpoint getProjectWebService();
    TaskWebServiceEndpoint getTaskWebService();
    UserWebServiceEndpoint getUserWebService ();
    ClientSessionService getClientSessionService();
    SerializationWebServiceEndpoint getSerializationWebService();
}
