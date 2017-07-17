package com.example.demo.dao.imp.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.imp.mybatis.mapper.UserMapper;
import com.example.demo.dao.model.UserModel;

@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	UserMapper userMapper;

	@Override
	public void deleteByPrimaryKey(Object primaryKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPrimaryKeys(Object... primaryKeys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByEntry(UserModel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(UserModel entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserts(UserModel... entrys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserModel entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByPrimaryKey(UserModel entry, Object... primaryKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UserModel entry, UserModel example) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateList(List<UserModel> list_t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotNull(UserModel entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByPrimaryKeyNotNull(UserModel entry, Object... primaryKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExampleNotNull(UserModel entry, UserModel example) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListNotNull(List<UserModel> list_t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel selectByPrimaryKey(Object primaryKey) {
		return userMapper.get((Long)primaryKey);
	}

	@Override
	public List<UserModel> selectByPrimaryKeys(Object... primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> selectPageByStartRow(UserModel entry, Long startRow, Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> selectPageByStartPrimaryKey(UserModel entry, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long selectCount(UserModel entry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> selectByEntry(UserModel entry) {
		// TODO Auto-generated method stub
		return null;
	}

}
