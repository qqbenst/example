package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EasyCodeRepository<T, ID extends Serializable> extends  JpaRepository<T, ID>, JpaSpecificationExecutor<T>{
	
	Collection<T> limit(Example<T> example, Limitable limitable);
	
	Collection<T> limit(Example<T> example, Limitable limitable, OffsetPrimaryKeySort keySort);
	
	int updateNotNullOneTable(T t, Example<T> example);
	
	int updateNotNullOneTable(T t, Iterator<ID> ids);
	
}
