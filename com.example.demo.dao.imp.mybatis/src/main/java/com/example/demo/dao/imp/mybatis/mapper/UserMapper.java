
package com.example.demo.dao.imp.mybatis.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.dao.model.UserModel;


/**
 * 持久化接口
 */
public interface UserMapper{
	  /**
     * 插入
     * 
     * @param t
     *            插入的对象
     * @return 插入数据条数
     */
    public int insert(UserModel userMode);


    /**
     * 批量插入
     * 
     * @param list
     *            数据列表
     * @return 插入数据条数
     */
    public int insertList(List<UserModel> list);


    /**
     * 修改
     * 
     * @param t
     *            修改的数据
     * @return 修改的数据条数
     */
    public int update(UserModel userMode);


    /**
     * 删除
     * 
     * @param id
     *            数据标识
     * @return 删除的数据条数
     */
    public int delete(Long id);


    /**
     * 通过条件查询记录数
     * 
     * @param t
     *            查询条件
     * @return 记录数
     */
    public int getTotal(UserModel userMode);


    /**
     * 通过条件查询数据列表
     * 
     * @param t
     *            查询条件
     * @return 数据列表
     */
    public List<UserModel> getList(UserModel userMode);


    /**
     * 查询所有数据
     * 
     * @return 数据列表
     */
    public List<UserModel> getAll();


    /**
     * 通过id查询数据
     * 
     * @param id
     *            数据标识
     * @return 数据对象
     */
    public UserModel get(Long id);


    /**
     * 根据条件分页查询
     * 
     * @param t
     *            查询参数
     * @param offset
     *            排序
     * @param rows
     *            分页
     * @return 分页数据列表
     */
    public List<UserModel> getPage(@Param("queryParam") UserModel userMode, @Param("offset") int offset, @Param("rows") int rows);
}