package com.example.demo.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Sort;

public class JpaLimitInfo<T> implements Limit{
	private List<T>content;
	private Sort sort;
	
	
	public JpaLimitInfo() {
		super();
	}

	
	public JpaLimitInfo(List<T> content, Sort sort) {
		super();
		this.content = content;
		this.sort = sort;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List content) {
		this.content = content;
	}
	
}
