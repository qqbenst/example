package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.dao.model.NextId;


public interface NextIdDao extends JpaRepository<NextId, BigInteger>,JpaSpecificationExecutor<NextId> {

}
