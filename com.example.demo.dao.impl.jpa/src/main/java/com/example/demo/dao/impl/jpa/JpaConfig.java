package com.example.demo.dao.impl.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.impl.jpa.support.EasyCodeRepositoryFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.dao.impl.jpa", repositoryFactoryBeanClass  = EasyCodeRepositoryFactoryBean.class)
@EntityScan(basePackages = "com.example.demo.dao.model")
public class JpaConfig {
}