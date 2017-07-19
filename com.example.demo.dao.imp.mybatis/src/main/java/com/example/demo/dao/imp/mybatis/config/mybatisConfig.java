package com.example.demo.dao.imp.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.dao.imp.mybatis.mapper")
public class mybatisConfig {

}
