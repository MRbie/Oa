package com.oa.action.role;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.impl.BaseAction;
import com.oa.dao.RoleDao;
import com.oa.po.Role;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author biexiansheng
 *
 * 创建日期:2017年7月18日
 *	
 * 角色管理的action
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//继承BaseAction<Role>泛型的参数内容是Role实体类名称
	
	//查询出角色的信息
	public String list(){
		
		//查询到所有的角色的信息放到了值栈中
		List<Role> list = roleService.findAll();
		
		//获取值栈ctrl+1可以起名字
		ValueStack valueStack = getValueStack();
		
		//使用set方法设置一下值，方便页面获取，压栈
		valueStack.set("list", list);
		
		//返回到struts.xml的配置文件中
		return "list";
	}
	
	/**
	 * 根据角色编号进行删除
	 * @return
	 */
	public String delete(){
	
		roleService.delete(model);
		
		return "toList";
	}
	
	
	/**
	 * 角色保存的方法
	 * @return
	 */
	public String save(){
		
		roleService.save(model);
		
		return "toList";
	}
	
	
	
	public String getById(){
	
		//根据角色编号查询出角色的信息
		Role role = roleService.getById(model.getRoleId());
		
		//获取值栈ctrl+1可以起名字
		ValueStack valueStack = getValueStack();
		
		//使用set方法设置一下值，方便页面获取，压栈
		//valueStack.set("role", role);
		valueStack.push(role);
		
		return "updateUI";
	}
	
	
	public String update(){
		//修改的方法
		//根据角色编号查询出角色的信息
		Role role = roleService.getById(model.getRoleId());
		
		//将要修改的信息保存封装到对象中
		role.setRoleName(model.getRoleName());
		role.setRoleDescription(model.getRoleDescription());
		
		roleService.update(role);
		
		return "toList";
	}
}
