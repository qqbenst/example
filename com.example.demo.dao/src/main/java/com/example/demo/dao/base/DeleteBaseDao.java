package com.example.demo.dao.base;

public interface DeleteBaseDao<T> {
	
	void deleteByPrimaryKey(Object primaryKey);
	
	void deleteByPrimaryKeys(Object ...primaryKey);
		
	void deleteByEntry(T entry);

}
