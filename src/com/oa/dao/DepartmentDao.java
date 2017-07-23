package com.oa.dao;

import java.util.List;

import com.oa.base.BaseDao;
import com.oa.po.Department;

/** 
* @author  Author:别先生 
* @date Date:2017年7月22日 上午11:13:09 
*
* 部门管理的增删改查接口继承基本的BaseDao接口
*/
public interface DepartmentDao extends BaseDao<Department>{

	/***
	 * 查询顶级部门的方法
	 * @return
	 */
	public List<Department> findTopList();

	/**
	 * 当顶级部门的编号不为空
	 * @param parentId
	 * @return
	 */
	public List<Department> findTopList(Long parentId);

	
}
