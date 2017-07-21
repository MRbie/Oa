package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.RoleDao;
import com.oa.po.Role;
import com.oa.service.RoleService;

/**
 * @author biexiansheng
 *
 * 创建日期:2017年7月18日
 * 
 * 实现类，角色管理的实现类。
 * 	注解，一个是开启业务逻辑层，一个是开启事务
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	//将角色的dao注入到ioc容器中
	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		
		//直接调用RoleDao的findAll()方法查询所有的角色的信息
		
		return roleDao.findAll();
	}

	@Override
	public void delete(Role model) {
		
		//删除的方法,将将要删除的角色id传递进来
		roleDao.delete(model.getRoleId());
	}

	@Override
	public void save(Role model) {
		
		//角色保存的方法
		roleDao.save(model);
	}

	@Override
	public Role getById(Long roleId) {
		
		//直接返回根据角色编号查询出的角色的信息
		
		return roleDao.getById(roleId);
	}

	@Override
	public void update(Role role) {
		
		//修改的方法
		roleDao.update(role);
	}

	
}
