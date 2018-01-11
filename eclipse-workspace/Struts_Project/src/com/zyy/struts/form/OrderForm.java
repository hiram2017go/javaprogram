package com.zyy.struts.form;

import org.apache.struts.action.ActionForm;

public class OrderForm extends ActionForm {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int num;
	private String detail;
	private int mealTypeID;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getMealTypeID() {
		return mealTypeID;
	}
	public void setMealTypeID(int mealTypeID) {
		this.mealTypeID = mealTypeID;
	}
}
