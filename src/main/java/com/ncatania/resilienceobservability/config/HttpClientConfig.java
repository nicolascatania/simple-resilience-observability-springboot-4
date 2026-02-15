package com.ncatania.resilienceobservability.config;

import com.ncatania.resilienceobservability.web.TodoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration(proxyBeanMethods = false)
@ImportHttpServices(TodoClient.class)
public class HttpClientConfig {
}
