package com.oa.service;

import java.util.List;

import com.oa.po.Department;

/** 
* @author  Author:别先生 
* @date Date:2017年7月22日 上午11:17:59 
*
* 部门的业务逻辑层的增删改查操作接口
*/
public interface DepartmentService {
 
	/**
	 * 部门查询的操作
	 * @return
	 */
	public List<Department> findAll();
	
	/**
	 * 部门添加的方法
	 * @param model
	 */
	public void save(Department model);
	
	/***
	 * 部门删除的方法
	 * @param model
	 */
	public void delete(Department model);
	
	/**
	 * 部门修改的方法
	 * @param model
	 */
	public void update(Department model);
	
	/***
	 * 部门根据编号查询部门信息的方法
	 * @param DepartmentId
	 * @return
	 */
	public Department getById(long departmentId);

	/***
	 * 查询顶级部门信息的方法
	 * @return
	 */
	public List<Department> findTopList();

	/**
	 * 当有顶级部门的时候，查询出所属的顶级部门信息
	 * @param parentId
	 * @return
	 */
	public List<Department> findTopList(Long parentId);
}
