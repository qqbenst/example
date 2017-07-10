package com.example.demo.dao.impl.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.impl.jpa.springdata.UserDAOSpringData;
import com.example.demo.dao.impl.jpa.support.Limitable;
import com.example.demo.dao.impl.jpa.support.LimitableImpl;
import com.example.demo.dao.impl.jpa.support.OffsetPrimaryKeySort;
import com.example.demo.dao.model.UserModel;

@Repository
public class UserDAOImpl implements UserDao {

	@Autowired
	UserDAOSpringData userDAO;
	@PersistenceContext
	private EntityManager em;

	@Override
	public void deleteByPrimaryKey(Object primaryKey) {
		 UserModel userModel = userDAO.findOne((Long) primaryKey);
		userDAO.delete(userModel.getId());
	}

	@Override
	public void deleteByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		userDAO.deleteByIdIn(Arrays.asList((Long[])primaryKeys));
	}

	@Override
	public void deleteByEntry(UserModel entity) {
		userDAO.delete(entity);

	}

	@Override
	public void insert(UserModel entry) {
		entry.setId(50L);
		entry.setCtime(System.currentTimeMillis());
		entry.setUtime(entry.getCtime());
		userDAO.save(entry);
	}

	@Override
	public void inserts(UserModel... entrys) {
		assert (entrys != null);
		List<UserModel> list = Arrays.asList(entrys);
		list.forEach(e ->{
			e.setCtime(System.currentTimeMillis());
			e.setUtime(e.getCtime());
		});
		userDAO.save(list);
	}

	@Override
	public void update(UserModel entry) {
		entry.setUtime(System.currentTimeMillis());
		userDAO.save(entry);
	}

	@Override
	public void updateByPrimaryKey(UserModel entry, Object... primaryKeys) {
	}

	@Override
	public void updateByExample(UserModel entry, UserModel example) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateList(List<UserModel> userModels) {
		userModels.forEach(e -> e.setUtime(System.currentTimeMillis()));
		userDAO.save(userModels);


	}

	@Override
	public void updateNotNull(UserModel entry) {
		UserModel userModel = userDAO.findOne(entry.getId());
		if (entry.getName() != null) {
			userModel.setName(entry.getName());
		}
		
		if(entry.getPassword() !=null){
			userModel.setPassword(entry.getPassword());
		}
		
		userModel.setUtime(System.currentTimeMillis());
		
		userDAO.save(userModel);
	}

	@Override
	public void updateByPrimaryKeyNotNull(UserModel entry, Object... primaryKey) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIncludeNullValues();
		Example<UserModel> example = Example.of(entry,matcher);
		
		
		em.createQuery("").executeUpdate();

		
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByExampleNotNull(UserModel entry, UserModel example) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateListNotNull(List<UserModel> userModels) {
		List<UserModel> models = userDAO.findAll(userModels.stream().map(UserModel::getId).collect(Collectors.toList()));
		long time = System.currentTimeMillis();
		models.stream().forEach(model -> {
			userModels.stream().filter(e -> (e.getId().equals(model.getId()))).findFirst().ifPresent(updateVule -> {
				if (updateVule.getName() != null) {
					model.setName(updateVule.getName());
				}
				
				if(updateVule.getPassword() !=null){
					model.setPassword(updateVule.getPassword());
				}
				
				model.setUtime(time);
			});
		});
		
		userDAO.save(userModels);

	}

	@Override
	public UserModel selectByPrimaryKey(Object primaryKey) {
		return userDAO.findOne((Long) primaryKey);
	}

	@Override
	public List<UserModel> selectByPrimaryKeys(Object... primaryKeys) {
		assert (primaryKeys != null);
		return (List<UserModel>) userDAO.findAll(Arrays.asList((Long[]) primaryKeys));
	}

	@Override
	public List<UserModel> selectPageByStartRow(UserModel entry, Long startRow, Long limit) {
		if (entry == null) {
			entry = new UserModel();
		}
		Example<UserModel> example = Example.of(entry);
		Limitable limitable = new LimitableImpl(startRow.intValue(), limit.intValue(),
				new Sort(Sort.Direction.DESC, "id"));
		return new ArrayList<>(userDAO.limit(example, limitable));
	}

	@Override
	public List<UserModel> selectPageByStartPrimaryKey(UserModel entry, Integer limit) {
		if (entry == null) {
			entry = new UserModel();
		}

		Example<UserModel> example = Example.of(entry);
		Limitable limitable = new LimitableImpl(0, limit.intValue(), new Sort(Sort.Direction.DESC, "id"));

		return (List<UserModel>) userDAO.limit(example, limitable, OffsetPrimaryKeySort.ASC);
	}

	public long selectCount(UserModel entry) {
		Example<UserModel> example = Example.of(entry);
		return userDAO.count(example);
	}

	public List<UserModel> selectAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	public List<UserModel> selectByEntry(UserModel entry) {
		Example<UserModel> example = Example.of(entry);
		return userDAO.findAll(example);
	}
}
