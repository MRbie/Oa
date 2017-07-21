package com.oa.service;

import java.util.List;

import com.oa.po.Role;

/**
 * @author biexiansheng
 *
 * 创建日期:2017年7月18日
 * 
 * 接口，角色管理的业务逻辑层
 */
public interface RoleService {

	/**
	 * 查询所有角色的信息
	 * @return
	 */
	public List<Role> findAll();

	/**
	 * 角色删除的方法
	 * @param model
	 */
	public void delete(Role model);
	
	/***
	 * 角色保存的方法
	 * @param model
	 */
	public void save(Role model);

	
	/***
	 * 根据角色的编号查询出角色的信息
	 * @param roleId
	 * @return
	 */
	public Role getById(Long roleId); 
	
	/***
	 * 修改的方法
	 */
	public void update(Role role);
	
}
