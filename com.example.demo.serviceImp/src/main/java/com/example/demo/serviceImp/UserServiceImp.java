package com.example.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.service.bean.UserBean;

import net.sf.cglib.beans.BeanCopier;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public UserBean findUserById(Long id) {
		UserModel userModel = userDao.selectByPrimaryKey(id);
		if (userModel == null) {
			return null;
		}
		UserBean userBean = new UserBean();
		BeanCopier b = BeanCopier.create(UserModel.class, UserBean.class, false);		
		b.copy(userModel, userBean, null);
		return userBean;
	}

	@Override
	public UserBean save(UserBean bean) {
		UserModel userModel = new UserModel();
		// bean.setUtime(System.currentTimeMillis());日期更新应该有dao层管理
		BeanCopier b = BeanCopier.create(UserBean.class, UserModel.class, false);
		b.copy(bean, userModel, null);
		userDao.insert(userModel);
		bean.setId(userModel.getId());
		b = BeanCopier.create(UserModel.class, UserBean.class, false);
		b.copy(userModel, bean, null);

		return bean;
	}

	@Override
	public void remove(Long id) {
		userDao.deleteByPrimaryKey(id);
		return ;
	}

	@Override
	public UserBean modify(UserBean bean) {
		//TODO 这个逻辑应该要处理，举个例子，应该先查询校验，再进行bean赋值 
		UserModel userModel = userDao.selectByPrimaryKey(bean.getId());
		// bean.setUtime(System.currentTimeMillis());日期更新应该有dao层管理
		BeanCopier b = BeanCopier.create(UserBean.class, UserModel.class, false);
		
		b.copy(bean, userModel, null);
		userDao.update(userModel);
		//bean.setId(userModel.getId());
		b = BeanCopier.create(UserModel.class, UserBean.class, false);
		b.copy(userModel, bean, null);
		
		return bean;
	}

}
