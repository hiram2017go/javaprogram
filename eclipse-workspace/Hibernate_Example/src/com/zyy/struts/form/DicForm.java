package com.zyy.struts.form;

import org.apache.struts.action.ActionForm;

public class DicForm extends ActionForm {

	private String name;
	private String category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
}
