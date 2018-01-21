package com.zyy.struts.form;

import org.apache.struts.action.ActionForm;

public class QuestionForm extends ActionForm {

	private String questionTypeID;
	
	private String questionKey;
	
	private String content;

	public String getQuestionTypeID() {
		return questionTypeID;
	}

	public void setQuestionTypeID(String questionTypeID) {
		this.questionTypeID = questionTypeID;
	}



	public String getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
