package com.example.demo.dao.impl.jpa.support;

import org.springframework.data.domain.Sort;

public interface Limitable {
	
	 Sort getSort();

	 void setSort(Sort sort);
	
	 int getOffset();
	
	 void setOffset(int offset);
	 
	 int getLimit();
	 
	 void setLimit(int limit);
	
	
}
