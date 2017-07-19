/*
 * Powered By xiaoshan
 * Since 2015 - 2017
 */

package com.example.demo.dao.imp.mybatis.config;

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
	public int deleteByPrimaryKey(Object primaryKey) {
		assert (primaryKey != null);
		return userMapper.deleteByPrimaryKey((Long) primaryKey);
	}

	@Override
	public int deleteByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		return userMapper.deleteByPrimaryKeys(Arrays.asList((Long[]) primaryKeys));
	}

	@Override
	public int deleteByEntry(UserModel entity) {
		assert (entity != null);
		return userMapper.deleteByEntry(entity);
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
	public int update(UserModel entity) {
		assert (entity != null);
		return userMapper.update(entity);
	}

	@Override
	public int updateByPrimaryKeys(UserModel entity, Object... primaryKeys) {
		assert (entity != null && primaryKeys != null);
		return userMapper.updateByPrimaryKeys(entity, Arrays.asList((Long[]) primaryKeys));

	}

	@Override
	public int updateByExample(UserModel entity, UserModel example) {
		assert (entity != null && example != null);
		return userMapper.updateByExample(entity, example);	
	}

	@Override
	public int updateNotNull(UserModel entity) {
		assert (entity != null);
		return userMapper.updateNotNull(entity);
	}

	@Override
	public int updateByPrimaryKeysNotNull(UserModel entity, Object... primaryKeys) {
		assert (entity != null && primaryKeys != null);
		return userMapper.updateByPrimaryKeyNotNull(entity, Arrays.asList((Long[]) primaryKeys));
		
	}

	@Override
	public int updateByExampleNotNull(UserModel entity, UserModel example) {
		assert (entity != null && example != null);
		return userMapper.updateByExampleNotNull(entity, example);	
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
