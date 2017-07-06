package com.example.demo.dao.impl.jpa.springdata;

import static com.example.demo.dao.impl.jpa.springdata.QueryByPageSpecs.*;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class QueryByPageRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements QueryByPageRepository<T, ID>{

	private final EntityManager entityManager;
	
	public QueryByPageRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public Page<T> selectByPage(T example, Pageable pageable) {
		return findAll(queryByPage(entityManager, example), pageable);
	}

}
