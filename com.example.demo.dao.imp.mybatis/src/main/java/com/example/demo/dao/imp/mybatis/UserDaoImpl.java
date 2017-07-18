/*
 * Powered By xiaoshan
 * Since 2015 - 2017
 */

package com.example.demo.dao.imp.mybatis;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.imp.mybatis.mapper.UserMapper;
import com.example.demo.dao.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserMapper userMapper;

	@Override
	public void deleteByPrimaryKey(Object primaryKey) {
		assert (primaryKey != null);
		userMapper.deleteByPrimaryKey((Long) primaryKey);
	}

	@Override
	public void deleteByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		userMapper.deleteByPrimaryKeys(Arrays.asList((Long[]) primaryKeys));
	}

	@Override
	public void deleteByEntry(UserModel entity) {
		assert (entity != null);
		userMapper.deleteByEntry(entity);
	}

	@Override
	public void insert(UserModel entity) {
		assert (entity != null);
		userMapper.insert(entity);
	}

	@Override
	public void inserts(UserModel... entries) {
		assert (entries != null);
		userMapper.inserts(Arrays.asList(entries));
	}

	@Override
	public void update(UserModel entity) {
		assert (entity != null);
		userMapper.insert(entity);
	}

	@Override
	public void updateByPrimaryKey(UserModel entity, Object... primaryKeys) {
		assert (entity != null && primaryKeys != null);
		userMapper.updateByPrimaryKeys(entity, Arrays.asList((Long[]) primaryKeys));

	}

	@Override
	public void updateByExample(UserModel entity, UserModel example) {
		assert (entity != null && example != null);
		userMapper.updateByExample(entity, example);	
	}


	@Override
	public void updateNotNull(UserModel entity) {
		assert (entity != null);
		userMapper.updateNotNull(entity);
	}

	@Override
	public void updateByPrimaryKeyNotNull(UserModel entity, Object... primaryKeys) {
		assert (entity != null && primaryKeys != null);
		userMapper.updateByPrimaryKeyNotNull(entity, Arrays.asList((Long[]) primaryKeys));
		
	}

	@Override
	public void updateByExampleNotNull(UserModel entity, UserModel example) {
		assert (entity != null && example != null);
		userMapper.updateByExampleNotNull(entity, example);	
	}


	@Override
	public UserModel selectByPrimaryKey(Object primaryKey) {
		assert (primaryKey != null);
		return userMapper.selectByPrimaryKey((Long)primaryKey);
	}

	@Override
	public List<UserModel> selectByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		return userMapper.selectByPrimaryKeys(Arrays.asList((Long[]) primaryKeys));
	}

	@Override
	public List<UserModel> selectListByStartRow(UserModel entity, Long startRow, Long limit) {
		assert (entity != null);
		assert (startRow >= 0);
		assert (limit >= 0);
		return 	userMapper.selectListByStartRow(entity, startRow, limit.intValue());
	}

	@Override
	public List<UserModel> selectListByStartPrimaryKey(UserModel entity, Integer limit) {
		assert (entity != null);
		assert (limit >= 0);
		return userMapper.selectListByStartPrimaryKey(entity, limit.intValue());
	}

	@Override
	public long selectCount(UserModel entity) {
		assert (entity != null);
		return userMapper.selectCount(entity);
	}

	@Override
	public List<UserModel> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public List<UserModel> selectByEntry(UserModel entity) {
		assert (entity != null);
		return userMapper.selectByEntry(entity);
	}

}
