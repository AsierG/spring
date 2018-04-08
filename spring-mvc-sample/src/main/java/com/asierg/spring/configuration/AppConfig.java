package com.asierg.spring.configuration;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.asierg.spring")
public class AppConfig {

    @Configuration
    @Profile("standard")
    @PropertySource("classpath:sample-config.properties")
    static class StandardProfile {

    }

    @Configuration
    @Profile("test")
    @PropertySource("classpath:sample-config-test.properties")
    static class TestProfile {

    }

}