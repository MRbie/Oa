
package com.oa.po;

import java.util.HashSet;
import java.util.Set;

public class Department {
	
	
	private Long departmentId;//部门编号
	private String departmentName;//部门名称
	private String departmentDescription;//部门描述
	
	//一个部门的上级部门
	private Department parent;//部门的父部门
	
	//部门的子部门，自关联
	//一个部门有多个下级部门
	private Set<Department> children = new HashSet<Department>();//
	
	//部门和用户的关系是一对多
	private Set<User> users = new HashSet<User>();

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
