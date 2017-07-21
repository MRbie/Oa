package com.oa.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oa.base.BaseDao;

/**
 * @author biexiansheng
 *
 *创建日期:2017年7月16日
 *
 *对公共的增删改查方法进行具体实现
 */
public class BaseDaoImpl<T> implements BaseDao<T>{

	//将sessionFactory注入到ioc容器中
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		//获得实体类型
		//this.getClass();这个获得的是子类的名称
		
		//获得真正的父类的名称,是什么类型
		//生成类型和名称的快捷键ctrl+1
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		//获取父类的类型之后开始获取泛型里面的内容
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
	
		//将获取到的第一个参数即实体类的名称传给clazz
		clazz = (Class<T>) actualTypeArguments[0];
	}
	
	
	@Override
	public void save(T entity) {
		//保存直接调用hibernate的保存的方法即可
		//将传递进来的entity参数保存到数据表中
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		//根据编号删除，需要先根据编号查询出来，然后根据编号进行删除
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(clazz, id));
	
	}

	@Override
	public void update(T entity) {
		//修改操作
		//即将要修改的内容放到update里面即可
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		//根据编号进行查询信息
		
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	
	@Override
	public List<T> findAll() {
		//查询所有
		//根据传递进来的实体类，将获取到简单的类名
		String hql = " from " + clazz.getSimpleName();
		
		//使用createQuery方法创建hql语句进行查询出所有的信息
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		//一次查询多个信息
		String hql = " from " + clazz.getSimpleName() + " where id in (:ids) ";
		
		//将查询语句作为参数进行传递
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		//一次赋值多个
		query.setParameterList("ids", ids);
		
		//将查询的结果返回回去
		return query.list();
	}

	
	
	//提取公共的语句
	public Session getSession(){
	
		//可以对上面的进行抽取替换，这样优化开发
		return sessionFactory.getCurrentSession();
	}
	
}
