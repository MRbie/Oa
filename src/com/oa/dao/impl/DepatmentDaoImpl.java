package com.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oa.base.impl.BaseDaoImpl;
import com.oa.dao.DepartmentDao;
import com.oa.po.Department;

/** 
* @author  Author:别先生 
* @date Date:2017年7月22日 上午11:16:08 
*
* 部门管理的数据交互层继承BaseDaoImpl基础的数据交互层的增删改查操作，实现自己的接口
*/
@Repository
@SuppressWarnings("unchecked")
public class DepatmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		
		//HQL语句
		String hql = " FROM Department d where d.parent is null ";
		
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public List<Department> findTopList(Long parentId) {
		
		//查询指定部门的子部门列表
		String hql = " from Department d where d.parent.departmentId = ? ";
		
		//返回查询的子部门信息
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
	}

	
}
