package com.example.demo.daoImp.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dao.model.UserModel;

@Mapper
public interface UserMapper {
	@Select("select * from user where id = #{id}")
    UserModel selectById(@Param("id")long id);
/*    
    @Insert("insert into user(id,status,nickname,sex,city,province,country,headimgurl,subscribe_time) "+
            "values(#{id},1,'nick',1,'city','provi','contr','img',now())")
    public void insert(@Param("id")int id);*/
}
