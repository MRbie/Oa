package com.oa.base;

import java.util.List;

/**
 * @author biexiansheng
 *
 *创建日期  2017年7月16日
 *
 *公共的增删改查的方法
 */
public interface BaseDao<T> {

	//添加信息
	public void save(T entity);
	
	//根据什么id进行删除
	public void delete(Long id);
	
	//根据id进行修改
	public void update(T entity);
	
	//根据id进行查询什么信息，修改的时候可以使用
	public T getById(Long id);
	
	//查询所有的信息
	public List<T> findAll();
	
	//一次查询多个对象
	public List<T> getByIds(Long[] ids);
}
