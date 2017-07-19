package com.example.demo.dao.imp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogicBaseMapper<T, ID> {

	public int deleteByPrimaryKey(ID primaryKey);

	public int deleteByPrimaryKeys(List<ID> primaryKeys);

	public int deleteByEntry(@Param("entity")T entity);

	public void insert(T entry);
	
	public void insertByNotNull(T entry);

	public void inserts(List<T> entries);
		
	public int update(T entry);

	public int updateByPrimaryKeys(@Param("entity")T entry, @Param("primaryKeys")List<ID> primaryKeys);

	public int updateByExample(@Param("entity")T entry, @Param("example")T example);

	public int updateNotNull(@Param("entity")T entry);

	public int updateByPrimaryKeyNotNull(@Param("entity")T entry,  @Param("primaryKeys")List<ID> primaryKeys);

	public int updateByExampleNotNull(@Param("entity")T entry, @Param("example")T example);

	public T selectByPrimaryKey(ID primaryKey);

	public List<T> selectByPrimaryKeys(List<ID> primaryKeys);

	public List<T> selectByEntry(@Param("example")T entry);

	public List<T> selectListByStartRow(@Param("example")T entry, @Param("offset")Long offset, @Param("limit")Integer limit);

	public List<T> selectListByStartPrimaryKey(@Param("example")T entry, @Param("limit")Integer limit);

	public long selectCount(@Param("example")T entry);

	public List<T> selectAll();
}
