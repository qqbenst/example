package com.example.demo.dao.impl.jpa;

import java.io.Serializable;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepositoryCustom<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>{
	JpaLimitInfo<T> limit(Example<T> example, JpaLimitSuport jpaLimitSuport);
}
