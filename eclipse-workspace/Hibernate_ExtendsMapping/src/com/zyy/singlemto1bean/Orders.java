package com.zyy.singlemto1bean;

public class Orders {
	private Integer id;
	private String name;
	private String orderNumner;
	private Customer customer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNumner() {
		return orderNumner;
	}
	public void setOrderNumner(String orderNumner) {
		this.orderNumner = orderNumner;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
