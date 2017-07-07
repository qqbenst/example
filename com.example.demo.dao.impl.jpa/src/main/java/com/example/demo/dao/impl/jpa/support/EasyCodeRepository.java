package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EasyCodeRepository<T, ID extends Serializable> extends  JpaRepository<T, ID>{
	Collection<T> limit(Example<T> example, Limitable limitable);
}
