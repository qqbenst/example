package com.example.demo.dao.impl.jpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.impl.jpa.springdata.UserDAOSpringDataImpl;
import com.example.demo.dao.model.UserModel;

@Repository
public class UserDAOImpl implements UserDao{

	@Autowired
	UserDAOSpringDataImpl userDAO;

	@Override
	public void deleteByPrimaryKey(Object primaryKey) {
		userDAO.delete((Long)primaryKey);
	}

	@Override
	public void deleteByPrimaryKeys(Object... primaryKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByEntry(UserModel entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(UserModel entry) {
		userDAO.save(entry);	
	}

	@Override
	public void inserts(UserModel ...entrys) {
		assert (entrys != null);
		userDAO.save(Arrays.asList(entrys));
	}

	@Override
	public void update(UserModel entry) {
		userDAO.save(entry);
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
		return userDAO.findOne((Long)primaryKey);
	}

	@Override
	public List<UserModel> selectByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		return (List<UserModel>) userDAO.findAll(Arrays.asList((Long[]) primaryKeys));
	}

	@Override
	public List<UserModel> selectPageByStartRow(UserModel entry, Long startRow, Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> selectPageByStartPrimaryKey(UserModel entry, Object startPrimaryKey, Integer limit) {
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
