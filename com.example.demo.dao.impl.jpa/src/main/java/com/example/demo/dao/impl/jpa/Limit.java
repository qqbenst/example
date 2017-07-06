package com.example.demo.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Sort;

public interface Limit {
	public Sort getSort();

	public void setSort(Sort sort);

	public List<?> getContent();
	
	public void setContent(List<?> content);
}
