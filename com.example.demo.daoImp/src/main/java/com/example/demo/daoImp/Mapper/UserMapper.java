package com.example.demo.daoImp.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dao.model.UserModel;

@Mapper
public interface UserMapper {
	@Select("select * from user where id = #{id}")
    UserModel selectById(@Param("id")long id);
    
    @Insert("insert into user(name,password,ctime,utime) "+
            "values(#{user.name},#{user.password},#{user.ctime},#{user.utime})")
    void insert(@Param("user")UserModel user);
    
    @Update("update user set name=#{user.name},password=#{user.password},ctime=#{user.ctime},utime=#{user.utime} where id =#{user.id}")
    void updateById(@Param("user")UserModel user);
    
    @Delete("delete user where id = #{id}")
    void deleteById(@Param("id")long id);
}
