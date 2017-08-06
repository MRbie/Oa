package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.UserDao;
import com.oa.po.User;
import com.oa.service.UserService;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月20日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		
		//将查询的内容返回回去
		List<User> list = userDao.findAll();
		
		//直接查询所有的用户信息
		return list;
	}

	@Override
	public void delete(User model) {
		// TODO Auto-generated method stub
		
		//用户删除的方法
		userDao.delete(model.getUserId());
	}

	@Override
	public void save(User model) {
		// TODO Auto-generated method stub
		
		//用户保存的方法
		userDao.save(model);
	}

	@Override
	public User getById(Long userId) {
		// TODO Auto-generated method stub
		
		//根据用户的编号获取用户的信息
		return userDao.getById(userId);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		//用户修改的方法
		userDao.update(user);
	}

	
}
