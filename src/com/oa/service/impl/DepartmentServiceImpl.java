package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.DepartmentDao;
import com.oa.po.Department;
import com.oa.service.DepartmentService;

/** 
* @author  Author:别先生 
* @date Date:2017年7月22日 上午11:18:40 
*
*
*/
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	//将部门信息的dao注入到ioc容器中
	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		
		//将查询出的部门的信息返回回来
		return departmentDao.findAll();
	}

	@Override
	public void save(Department model) {
		
		//将部门的信息保存起来
		departmentDao.save(model);
	}

	@Override
	public void delete(Department model) {
		
		//根据部门的编号进行删除操作
		departmentDao.delete(model.getDepartmentId());
	}

	@Override
	public void update(Department model) {
		
		//将修改部门的信息
		departmentDao.update(model);
	}

	@Override
	public Department getById(long departmentId) {
		
		//将查询出来的部门信息返回回去
		return departmentDao.getById(departmentId);
	}

	@Override
	public List<Department> findTopList() {
		
		List<Department> list = departmentDao.findTopList();
		
		return list;
	}

	@Override
	public List<Department> findTopList(Long parentId) {
		
		//当顶级部门的编号不为空的时候
		List<Department> list = departmentDao.findTopList(parentId);
		
		return list;
	}

	
}
