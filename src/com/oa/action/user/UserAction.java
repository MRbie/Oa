package com.oa.action.user;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.impl.BaseAction;
import com.oa.po.User;
import com.opensymphony.xwork2.util.ValueStack;

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
		valueStack.set("list", list);
		
		return "list";
	}
}
