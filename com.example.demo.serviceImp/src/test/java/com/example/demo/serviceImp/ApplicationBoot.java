package com.example.demo.serviceImp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.demo"})
@MapperScan("com.example.demo.daoImp.Mapper")
public class ApplicationBoot {
	
	 public static void main(String[] args) throws Exception {

	        SpringApplication.run(ApplicationBoot.class, args);
	    }
}
