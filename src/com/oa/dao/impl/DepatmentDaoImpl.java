package com.oa.dao.impl;

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
public class DepatmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

	
}
