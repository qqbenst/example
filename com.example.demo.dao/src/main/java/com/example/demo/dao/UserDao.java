package com.example.demo.dao;

import com.example.demo.dao.model.UserModel;

public interface UserDao {
	
	void insert(UserModel model);
	
	UserModel selectById(long id);
	
	void updateById(UserModel userModel);
	
	void deleteById(long id);
}
