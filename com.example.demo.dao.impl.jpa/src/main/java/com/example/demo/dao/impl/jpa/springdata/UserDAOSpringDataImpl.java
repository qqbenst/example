package com.example.demo.dao.impl.jpa.springdata;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dao.model.UserModel;

public interface UserDAOSpringDataImpl extends CrudRepository<UserModel, Long>{

}
