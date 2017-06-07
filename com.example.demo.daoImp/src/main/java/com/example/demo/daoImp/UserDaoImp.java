package com.example.demo.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserModel;
import com.example.demo.daoImp.Mapper.UserMapper;

@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void insert(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel selectById(long id) {
		return userMapper.selectById(id);
	}
}
