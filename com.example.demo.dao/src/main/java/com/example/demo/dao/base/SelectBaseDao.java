package com.example.demo.dao.base;

import java.util.List;

public interface SelectBaseDao<T> {
	
	T selectByPrimaryKey(Object primaryKey);
	
	List<T> selectByPrimaryKeys(Object ...primaryKey);
	
	List<T> selectListByStartRow(T entry, Long startRow, Long limit);
	
	List<T> selectListByStartPrimaryKey(T entry, Integer limit);
	
	long selectCount(T entry);
	
	List<T> selectAll();
	
	List<T> selectByEntry(T entry);

}
