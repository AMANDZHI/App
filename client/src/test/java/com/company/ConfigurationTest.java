package com.company;

import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.SessionWebServiceEndpoint;
import com.company.api.TaskWebServiceEndpoint;
import com.company.api.UserWebServiceEndpoint;
import com.company.endpoint.ProjectWebServiceEndpointImplService;
import com.company.endpoint.SessionWebServiceEndpointImplService;
import com.company.endpoint.TaskWebServiceEndpointImplService;
import com.company.endpoint.UserWebServiceEndpointImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {
    @Bean
    public SessionWebServiceEndpoint sessionWebService() {
        return new SessionWebServiceEndpointImplService().getSessionWebServiceEndpointImplPort();
    }

    @Bean
    public ProjectWebServiceEndpoint projectWebService() {
        return new ProjectWebServiceEndpointImplService().getProjectWebServiceEndpointImplPort();
    }

    @Bean
    public TaskWebServiceEndpoint taskWebService() {
        return new TaskWebServiceEndpointImplService().getTaskWebServiceEndpointImplPort();
    }

    @Bean
    public UserWebServiceEndpoint userWebService() {
        return new UserWebServiceEndpointImplService().getUserWebServiceEndpointImplPort();
    }
}
