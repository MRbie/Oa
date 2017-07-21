package com.oa.po;
import java.util.HashSet;
import java.util.Set;
/**
 * 岗位实体
 */
public class Role {
	
	private Long roleId;//角色编号
	private String roleName;//角色名称roleName roleDescription
	private String roleDescription;//角色描述
	
	//角色和用户是多对多的关系
	private Set<User> users = new HashSet<User>();//用户实体类

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
