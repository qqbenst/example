package com.example.demo.dao.base;

import java.util.List;

public interface UpdateBaseDao<T> {
	
	Integer update(T entry);
	
	Integer updateByPrimaryKey(T entry, Object ...primaryKey);
	
	Integer updateByExample(T entry, T example);
	
	Integer updateList(List<T> list_t);
	
	Integer updateNotNull(T entry);
	
	Integer updateByPrimaryKeyNotNull(T entry, Object ...primaryKey);
	
	Integer updateByExampleNotNull(T entry, T example);
	
	Integer updateListNotNull(List<T> list_t);
	

}
