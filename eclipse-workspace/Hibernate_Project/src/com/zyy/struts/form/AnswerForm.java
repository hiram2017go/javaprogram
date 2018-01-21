package com.zyy.struts.form;

import org.apache.struts.action.ActionForm;

public class AnswerForm extends ActionForm {
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
