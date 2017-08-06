package com.oa.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import com.oa.service.DepartmentService;
import com.oa.service.RoleService;
import com.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/***
 * 通用父类action
 * @author biexiansheng
 *
 * 创建日期:2017年7月16日
 *	
 * 公共的BaseAction类里面的公共的方法
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	
	private static final long serialVersionUID = 1L;

	//将角色的service注入到ioc容器中
	@Resource
	public RoleService roleService;
	
	//将用户的service注入到ioc容器中
	@Resource
	public UserService userService;

	//将部门的service注入到ioc容器中
	@Resource
	public DepartmentService departmentService;
	
	//构造方法
	@SuppressWarnings("unchecked")
	public BaseAction(){
		//获取到BaseAction的这个名称
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		//获取父类的类型之后开始获取泛型里面的内容
		Type[] types = genericSuperclass.getActualTypeArguments();
		
		////将获取到的第一个参数即实体类的名称传给clazz
		Class<T> clazz = (Class<T>) types[0];
		
		try {
			//将获取的参数名称传给model
			model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	//声明model类型
	protected T model;
	
	@Override
	public T getModel() {
		
		//返回model类型
		return model;
	}

	/***
	 * 获得值栈
	 * @return
	 */
	protected ValueStack getValueStack(){
		//直接返回值栈
		return ActionContext.getContext().getValueStack();
	}
	
}
