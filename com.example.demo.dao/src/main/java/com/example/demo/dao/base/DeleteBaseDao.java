package com.example.demo.dao.base;

public interface DeleteBaseDao<T> {
	
	int deleteByPrimaryKey(Object primaryKey);
	
	int deleteByPrimaryKeys(Object ...primaryKeys);
		
	int deleteByEntry(T entity);

}
