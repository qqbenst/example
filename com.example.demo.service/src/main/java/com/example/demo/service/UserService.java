package com.example.demo.service;

import com.example.demo.service.bean.UserBean;

public interface UserService {
	public UserBean findUserById(Long id);

	public UserBean save(UserBean bean);

	public void remove(Long id);

	public UserBean modify(UserBean bean);

}
