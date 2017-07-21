package com.oa.service.impl;

import java.util.List;

import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;

import com.oa.dao.UserDao;
import com.oa.po.User;
import com.oa.service.UserService;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月20日
 */
@Service
public class UserServiceImpl implements UserService{

	@Source
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		
		//直接查询所有的用户信息
		return userDao.findAll();
	}

	
}
