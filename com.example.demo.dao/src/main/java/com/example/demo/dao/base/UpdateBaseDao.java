package com.example.demo.dao.base;

import java.util.List;

public interface UpdateBaseDao<T> {
	
	void update(T entry);
	
	void updateByPrimaryKey(T entry, Object ...primaryKey);
	
	void updateByExample(T entry, T example);
		
	void updateNotNull(T entry);
	
	void updateByPrimaryKeyNotNull(T entry, Object ...primaryKey);
	
	void updateByExampleNotNull(T entry, T example);	

}
