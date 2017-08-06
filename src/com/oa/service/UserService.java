package com.oa.service;

import java.util.List;

import com.oa.po.Role;
import com.oa.po.User;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月20日
 * 
 * 用户用户的业务逻辑层接口
 */

public interface UserService {

	/**
	 * 查询所有的用户信息
	 */
	public List<User> findAll();

	/**
	 * 用户删除的方法
	 * @param model
	 */
	public void delete(User model);
	
	/***
	 * 用户保存的方法
	 * @param model
	 */
	public void save(User model);

	
	/***
	 * 根据用户的编号查询出用户的信息
	 * @param userId
	 * @return
	 */
	public User getById(Long userId); 
	
	/***
	 * 修改的方法
	 */
	public void update(User user);
}
