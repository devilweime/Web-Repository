package com.b2c.commons.pojo;

import java.util.List;

public class AllNode<T>{

	private T name;//分类名
	private Integer id;//分类id
	private List<?> child;//子分类集合，没有则应为null
	
	public List<?> getChild() {
		return child;
	}
	public void setChild(List<?> child) {
		this.child = child;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
