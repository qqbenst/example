package com.example.demo.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.dao")
@EntityScan(basePackages = "com.example.demo.dao.model")

public class NextIdJpaConfiguer {

}
