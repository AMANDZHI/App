package com.company.config;

import com.company.api.*;
import com.company.endpoint.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.company")
public class SpringConfiguration {

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

    @Bean
    public SerializationWebServiceEndpoint serializationWebService() {
        return new SerializationWebServiceEndpointImplService().getSerializationWebServiceEndpointImplPort();
    }
}
