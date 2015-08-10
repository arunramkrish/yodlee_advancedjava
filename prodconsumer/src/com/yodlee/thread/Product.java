package com.yodlee.thread;

import java.util.Date;

public class Product {
	private String name;
	private long id;
	private Date createTime;
	public Product(String name, long id, Date createTime) {
		super();
		this.name = name;
		this.id = id;
		this.createTime = createTime;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", createTime="
				+ createTime + "]";
	}
	
}
