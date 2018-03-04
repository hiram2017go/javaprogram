package com.zyy.dao;

import java.util.List;

import com.zyy.bean.Answer;

public interface AnswerDao {

	public void save(Answer a);
	
	public List listAnswerByQuestionID(Integer questionID);
	
	public List answerDetailLstById(Integer questionID);
}
