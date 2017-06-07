package com.example.demo.serviceImp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.service.bean.UserBean;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public UserBean findUserById(Long id) {
		UserModel userModel = userDao.selectById(id);
		if (userModel == null) {
			return null;
		}
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(userModel, userBean);
		return userBean;
	}

}
