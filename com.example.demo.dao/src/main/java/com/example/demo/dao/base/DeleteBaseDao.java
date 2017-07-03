package com.example.demo.dao.base;

public interface DeleteBaseDao<T> {
	
	void deleteByPrimaryKey(Object primaryKey) throws Exception;
	
	void deleteByPrimaryKeys(Object ...primaryKey) throws Exception;
	
	void deleteByTime(Integer beginTime, Integer endTime) throws Exception;
	
	void deleteByEntry(T entry) throws Exception;

}
