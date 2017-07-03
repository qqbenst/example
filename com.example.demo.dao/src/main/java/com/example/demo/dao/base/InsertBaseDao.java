package com.example.demo.dao.base;

import java.util.List;

public interface InsertBaseDao<T> {
	
	Integer insert(T entry);
    
	Integer insertList(List<T> list_entry);
	
	
}
