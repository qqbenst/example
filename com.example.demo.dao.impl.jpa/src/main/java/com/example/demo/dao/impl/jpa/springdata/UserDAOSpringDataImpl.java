package com.example.demo.dao.impl.jpa.springdata;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.dao.impl.jpa.BaseRepositoryCustom;
import com.example.demo.dao.model.UserModel;

public interface UserDAOSpringDataImpl extends JpaRepository<UserModel, Long>,BaseRepositoryCustom<UserModel, Long>{

	@Query(value = "select * from user where user =?1" + "\n#pageable\n",nativeQuery = true)
	List<UserModel> fuckPageByStartRow(Example<UserModel> example, Pageable pageable);
	
}
