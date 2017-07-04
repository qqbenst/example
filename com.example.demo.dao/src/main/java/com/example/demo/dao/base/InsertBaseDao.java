package com.example.demo.dao.base;

public interface InsertBaseDao<T> {
	
	void insert(T entry);
    
	void inserts(T ...entrys);
}
