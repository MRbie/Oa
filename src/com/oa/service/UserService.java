package com.oa.service;

import java.util.List;

import com.oa.po.User;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月20日
 * 
 * 用户角色的业务逻辑层接口
 */

public interface UserService {

	/**
	 * 查询所有的用户信息
	 */
	public List<User> findAll();

	
}
