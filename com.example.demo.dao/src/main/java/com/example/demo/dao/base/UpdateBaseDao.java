package com.example.demo.dao.base;

public interface UpdateBaseDao<T> {
	
	int update(T entry);
	
	int updateByPrimaryKeys(T entry, Object ...primaryKey);
	
	int updateByExample(T entry, T example);
		
	int updateNotNull(T entry);
	
	int updateByPrimaryKeysNotNull(T entry, Object ...primaryKeys);
	
	int updateByExampleNotNull(T entry, T example);	

}
