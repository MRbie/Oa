package com.ao.department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.oa.po.Department;

/** 
* @author  Author:别先生 
* @date Date:2017年7月31日 下午10:23:57 
*
* 注意：
* 	不能使用多层循环的方式，因为需要能支持任意层。
* 	使用递归的方式完成
*/
public class TreeViewPractice {
	/**
	 * 结构如下：
	 * 
	 * <pre>
	 * ┣市场部
	 *    ┣宣传部
	 *    ┣业务部
	 *       ┣业务一部
	 *       ┣业务二部
	 * ┣开发部
	 *    ┣开发一部
	 *    ┣开发二部
	 * </pre>
	 * 
	 * @return 所有最顶层的部门的列表
	 */
	public static List<Department> findTopLevelDepartmentList() {
		Department dept_1_1 = new Department();
		dept_1_1.setDepartmentId(new Long(11));
		dept_1_1.setDepartmentName("宣传部");

		Department dept_1_2 = new Department();
		dept_1_2.setDepartmentId(new Long(12));
		dept_1_2.setDepartmentName("业务部");

		Department dept_1_2_1 = new Department();
		dept_1_2_1.setDepartmentId(new Long(121));
		dept_1_2_1.setDepartmentName("业务一部");

		Department dept_1_2_2 = new Department();
		dept_1_2_2.setDepartmentId(new Long(122));
		dept_1_2_2.setDepartmentName("业务二部");

		dept_1_2_1.setParent(dept_1_2);
		dept_1_2_2.setParent(dept_1_2);
		Set<Department> children_0 = new LinkedHashSet<Department>();
		children_0.add(dept_1_2_1);
		children_0.add(dept_1_2_2);
		dept_1_2.setChildren(children_0);

		// ================================

		Department dept_1 = new Department();
		dept_1.setDepartmentId(new Long(1));
		dept_1.setDepartmentName("市场部");

		dept_1_1.setParent(dept_1);
		dept_1_2.setParent(dept_1);
		Set<Department> children_1 = new LinkedHashSet<Department>();
		children_1.add(dept_1_1);
		children_1.add(dept_1_2);
		dept_1.setChildren(children_1);

		// ---

		Department dept_2_1 = new Department();
		dept_2_1.setDepartmentId(new Long(21));
		dept_2_1.setDepartmentName("开发一部");

		Department dept_2_2 = new Department();
		dept_2_2.setDepartmentId((new Long(22)));
		dept_2_2.setDepartmentName("开发二部");

		Department dept_2 = new Department();
		dept_2.setDepartmentId(new Long(2));
		dept_2.setDepartmentName("开发部");

		dept_2_1.setParent(dept_2);
		dept_2_2.setParent(dept_2);
		Set<Department> children_2 = new LinkedHashSet<Department>();
		children_2.add(dept_2_1);
		children_2.add(dept_2_2);
		dept_2.setChildren(children_2);

		//
		List<Department> depts = new ArrayList<Department>();
		depts.add(dept_1);
		depts.add(dept_2);
		return depts;
	}

	
	//列出演示数据
	@Test
	public void show(){
		List<Department> list = findTopLevelDepartmentList();
		System.out.println(list);
	}
	
	
	//列出所有的部门,方法一
	@Test
	public void show2(){
		List<Department> list = findTopLevelDepartmentList();
		for(Department d : list){
			showTree2(d);
		}		
	}

	public void showTree2(Department d){
		//顶树
		System.out.println(d.getDepartmentName());
		//子树
		Set<Department> children = d.getChildren();
		for(Department de : children){
			showTree2(de);
		}
	}
	
	
	
	//列出部门的树，方法二
	@Test
	public void show3(){
		List<Department> list = findTopLevelDepartmentList();
		showTree3(list, "┣");	
	}
	
	//规律，子部门比上级部门多两个空格
	private void showTree3(Collection<Department> list ,String prefix) {
		for(Department de : list){
			//顶树
			System.out.println( prefix + de.getDepartmentName());
			//子树
			Set<Department> children = de.getChildren();
			showTree3(children,"    " +  prefix);
		}
		
	}


	


}
