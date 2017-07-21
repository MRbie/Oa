package com.oa.po;

import java.util.HashSet;
import java.util.Set;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月16日
 *
 *用户的实体类
 */
public class User {
	
	
	private Long userId;//用户编号
	private String userLoginName;//用户登陆名称
	private String userName;//用户姓名
	private int userGender;//用户年龄
	private String userPhone;//用户电话
	private String userEmail;//用户邮箱
	private String userDescription;//用户描述
	private String userPassword;//用户密码
	
	//用户所属的部门，用户和部门是多对一
	private Department department;//用户所属部门
	
	//用户的角色
	//角色和用户是多对多的关系
	private Set<Role> roles = new HashSet<Role>();//

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
