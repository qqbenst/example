package com.example.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.demo"})
public class ApplicationBoot {
	
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(ApplicationBoot.class, args);
	    }
}
