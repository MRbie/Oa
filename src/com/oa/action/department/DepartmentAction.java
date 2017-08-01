package com.oa.action.department;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.impl.BaseAction;
import com.oa.po.Department;
import com.oa.utils.DepartmentUtils;
import com.opensymphony.xwork2.util.ValueStack;

/** 
* @author  Author:别先生 
* @date Date:2017年7月22日 上午11:31:47 
*
*
*/
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	
	private static final long serialVersionUID = 1L;

	//父类型的部门id,此种不是模型驱动，是属性驱动
	private Long parentId;
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String list(){
		//调用业务逻辑层的查询所有信息的方法
		//List<Department> list = departmentService.findAll();
		List<Department> list = null;
		//部门管理，设计如何选择顶级部门和下级部门点进去查看的时候
		if(parentId == null){
			//如果父级部门编号为空，那么查询你顶级部门列表
			list =  departmentService.findTopList();
		}else{
			//如果父级部门编号不为空，那么查询子部门列表
			list = departmentService.findTopList(parentId);
			
			//返回上一级的设计
			Department departmentParent = departmentService.getById(parentId);
		
			//压栈操作
			getValueStack().set("departmentParent", departmentParent);
		}
		
		//ctrl+1 获得值栈
		ValueStack valueStack = getValueStack();
		
		//压栈操作
		//规律，如果获取的是列表就用set方法，如果是单个的对象就用push方法
		valueStack.set("list", list);
		
		//返回到struts.xml的配置文件
		return "list";
	}
	
	public String addUI(){
		//调用业务逻辑层的查询所有信息的方法
		//List<Department> list = departmentService.findAll();
		
		//所有的顶级部门列表
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		//获取值栈
		ValueStack valueStack = getValueStack();		
		
		//压栈操作，这样可以获取到部门信息
		valueStack.set("list", treeList);
				
		return "addUI";
	}
	
	public String save(){
		//如果父部门不为空，那么就执行根据父部门id查询
		if(parentId != null){
			Department department = departmentService.getById(parentId);
			
			//设置上级部门
			model.setParent(department);
		}else{
			//如果上级部门id为空，就将上级部门设置为空
			model.setParent(null);
		}
		
		//部门保存的方法
		departmentService.save(model);
		
		return "toList";
	}
	
	
	public String delete(){
		
		//部门删除的方法
		departmentService.delete(model);
		
		return "toList";
	}
	
	public String update(){
		//按照编号查询部门信息的方法
		Department department = departmentService.getById(model.getDepartmentId());
				
		department.setDepartmentName(model.getDepartmentName());
		department.setDepartmentDescription(model.getDepartmentDescription());
		//设置顶级部门的方法
		if(parentId != null){
			Department parent = departmentService.getById(parentId);
			//设置上级部门
			model.setParent(parent);
		}else{
			model.setParent(null);
		}
		//设置上一级部门
		department.setParent(model.getParent());
	
		//直接调用业务逻辑层修改的方法
		departmentService.update(department);
	
		return "toList";
	}
	
	
	public String getById(){
		
		//按照编号查询部门信息的方法
		Department department = departmentService.getById(model.getDepartmentId());
		
		//获取到值栈
		ValueStack valueStack = getValueStack();
	
		//将部门的对象push到值栈中
		valueStack.push(department);
		
		
		//准备数据，调用业务逻辑层的查询所有信息的方法
		//List<Department> list = departmentService.findAll();
		//所有的顶级部门列表
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, department.getDepartmentId());
				
		//获取值栈
		ValueStack valueStackSelect = getValueStack();		
		
		//压栈操作，这样可以获取到部门信息
		valueStackSelect.set("list", treeList);
		
		if(department.getParent() != null){
			//将上级部门设计一下,这样将父级部门放到值栈中
			parentId = department.getParent().getDepartmentId();
		}
		
		return "updateUI";
	}
}
