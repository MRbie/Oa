package com.oa.action.user;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.impl.BaseAction;
import com.oa.po.Department;
import com.oa.po.Role;
import com.oa.po.User;
import com.oa.utils.DepartmentUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author bhlgo
 * 
 * 用户操作的控制层
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String list(){
		
		//查询到所有的用户的信息放到了值栈中
		List<User> list = userService.findAll();
		
		//获取栈里面的内容
		ValueStack valueStack = getValueStack();
		
		////使用set方法设置一下值，方便页面获取，压栈
		valueStack.set("userList", list);
		
		return "list";
	}
	
	/**
	 * 根据用户的编号进行删除操作
	 * @return
	 */
	public String delete(){
		
		//删除的方法
		userService.delete(model);
		
		//删除以后返回用户列表页面
		return "toList";
	}
	
	
	/***
	 * 跳转到用户添加的页面
	 * @return
	 */
	public String addUi(){
		
		
		//所有的顶级部门列表
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		//获取值栈
		ValueStack valueStack = getValueStack();		
		
		//压栈操作，这样可以获取到部门信息
		valueStack.set("treeList", treeList);
		
		//查询出所有的角色信息即岗位信息
		List<Role> roleList = roleService.findAll();
		
		//将岗位信息压倒栈里面
		valueStack.set("roleList", roleList);
		
		//跳转到用户新建的页面
		return "addUI";
	}
	
	
	/***
	 * 用户添加的方法
	 * @return
	 */
	public String save(){
		
		//保存用户的信息
		userService.save(model);
		
		return "toList";
	}
	
	
	/***
	 * 根据用户的编号进行查询用户的信息
	 * @return
	 */
	public String getById(){
		
		//根据用户的编号查询用户的信息
		User user = userService.getById(model.getUserId());
		
		//获取到值栈
		ValueStack valueStack = getValueStack();
		
		//压栈操作
		valueStack.push(user);
		
		//所有的顶级部门列表
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		//获取值栈
		//ValueStack valueStack = getValueStack();		
		
		//压栈操作，这样可以获取到部门信息
		valueStack.set("treeList", treeList);
		
		//查询出所有的角色信息即岗位信息
		List<Role> roleList = roleService.findAll();
		
		//将岗位信息压倒栈里面
		valueStack.set("roleList", roleList);
		return "updateUi";
	}
	
	
	/***
	 * 用户修改的方法
	 * @return
	 */
	public String update(){
		
		//根据用户的编号查询出用户的信息
		User user = userService.getById(model.getUserId());
		
		//将需要修改的用户信息重新设置一遍
		user.setUserName(model.getUserName());
		user.setUserLoginName(model.getUserLoginName());
		user.setUserGender(model.getUserGender());
		user.setUserPhone(model.getUserPhone());
		user.setUserPassword(model.getUserPassword());
		user.setUserEmail(model.getUserEmail());
		user.setUserDescription(model.getUserDescription());
		user.setDepartment(model.getDepartment());
		user.setRoles(model.getRoles());
		
		
		//修改用户的信息
		userService.update(user);
		
		return "toList";
	}
	
	/**
	 * 初始化用户的密码
	 * @return
	 */
	public String initPassword(){
		
		return "";
	}
}

