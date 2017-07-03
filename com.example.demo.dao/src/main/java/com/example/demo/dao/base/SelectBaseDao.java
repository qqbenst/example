package com.example.demo.dao.base;

import java.util.List;

public interface SelectBaseDao<T> {
	
	T selectByPrimaryKey(Object primaryKey) throws Exception;
	
	List<T> selectByPrimaryKeys(Object ...primaryKey) throws Exception;
	
	List<T> selectByPage(T entry, Integer startRow, Integer pageSize) throws Exception;
	
	Integer selectCount(T entry) throws Exception;
	
	List<T> selectAll() throws Exception;
	
	List<T> selectByEntry(T entry) throws Exception;

}
