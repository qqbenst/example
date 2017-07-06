package com.example.demo.dao.impl.jpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.jpa.criteria.CriteriaQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.PropertySpecifier;
import org.springframework.data.domain.ExampleMatcher.PropertySpecifiers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	if(entry==null){
			entry = new UserModel();
		}
		
		Example<UserModel> example = Example.of(entry);
		JpaLimitSuport jpaLimitSuport = new JpaLimitSuport(startRow.intValue(), limit.intValue(), new Sort("id"));
/*		//	return userDAO.findAll(example, pageable).getContent();
		ExampleMatcher exampleMatcher = example.getMatcher();
		PropertySpecifiers propertySpecifiers = exampleMatcher.matchingAll().getPropertySpecifiers();
		Collection<PropertySpecifier> propertySpecifiers1 = (Collection<PropertySpecifier>) exampleMatcher.getPropertySpecifiers().getSpecifiers();
		System.out.println("");
		System.out.println(propertySpecifiers.toString());*/
		return  userDAO.limit(example, jpaLimitSuport).getContent();                //userDAO.fuckPageByStartRow(example, pageable);
	}

	@Override
	public List<UserModel> selectPageByStartPrimaryKey(UserModel entry, Object startPrimaryKey, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long selectCount(UserModel entry) {
		Example<UserModel> example = Example.of(entry);
		return userDAO.count(example);
	}

	@Override
	public List<UserModel> selectAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public List<UserModel> selectByEntry(UserModel entry) {
		Example<UserModel> example = Example.of(entry);
		return userDAO.findAll(example);
	} 
}
