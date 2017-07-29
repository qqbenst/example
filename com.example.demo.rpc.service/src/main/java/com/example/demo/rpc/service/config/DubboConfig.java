package com.example.demo.rpc.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration  
@PropertySource("dubbo.properties")  
@ImportResource({ "*.xml" })  
public class DubboConfig {

}
