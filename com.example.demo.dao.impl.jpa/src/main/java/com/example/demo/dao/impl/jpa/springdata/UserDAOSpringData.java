package com.example.demo.dao.impl.jpa.springdata;

import java.util.List;

import com.example.demo.dao.impl.jpa.support.EasyCodeRepository;
import com.example.demo.dao.model.UserModel;

public interface UserDAOSpringData extends EasyCodeRepository<UserModel, Long>{
	
	void deleteByIdIn(List<Long> ids);
	
}
