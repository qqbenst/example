package com.example.demo.dao.impl.jpa.support;

import org.springframework.data.domain.Sort;

public class LimitableImpl implements Limitable{
	private Sort sort;
	
	private int offset;
	
	private int limit;

	public LimitableImpl(int offset, int limit, Sort sort) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.sort = sort;
	}

	@Override
	public Sort getSort() {
		return this.sort;
	}

	@Override
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	@Override
	public int getOffset() {
		return offset;
	}
	
	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	@Override
	public int getLimit() {
		return limit;
	}
	
	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}

	
}
