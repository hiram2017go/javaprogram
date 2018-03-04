package com.zyy.dao;

import java.util.List;

import com.zyy.bean.Question;
import com.zyy.bean.QuestionType;

public interface QuestionDao {

	public List listQuestion() ;
	
	public List listQuestionType();
	
	public void save(Question q);
	
	public QuestionType getQuestion(Integer id);
	
	public List questionDetailList();
	
	public Question getQuestionDetailById(Integer id);
	
	public Question getQuestionById(Integer id);
	
	public void updateAnswerCount(Integer id);
}
