package com.zyy.bean;

public class Question {

//	CREATE TABLE `questiontbl` (
//			  `id` int(11) NOT NULL AUTO_INCREMENT,
//			  `createTime` varchar(20) DEFAULT NULL,
//			  `systemMemberID` int(11) DEFAULT NULL,
//			  `questionTypeID` int(11) DEFAULT NULL,
//			  `questionKey` varchar(20) DEFAULT NULL,
//			  `content` varchar(100) DEFAULT NULL,
//			  `answerCount` int(11) DEFAULT '0',
//			  PRIMARY KEY (`id`),
//			  KEY `question_systemmember_fk_idx` (`systemMemberID`),
//			  KEY `question_questiontype_fk_idx` (`questionTypeID`),
//			  CONSTRAINT `question_questiontype_fk` FOREIGN KEY (`questionTypeID`) REFERENCES `questiontypetbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
//			  CONSTRAINT `question_systemmember_fk` FOREIGN KEY (`systemMemberID`) REFERENCES `systemmembertbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8
	
	private Integer id;
	private  String createTime;
	private SystemMember sm;
	private QuestionType qt;
	private String questionKey;
	private String content;
	private int answerCount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public SystemMember getSm() {
		return sm;
	}
	public void setSm(SystemMember sm) {
		this.sm = sm;
	}
	public QuestionType getQt() {
		return qt;
	}
	public void setQt(QuestionType qt) {
		this.qt = qt;
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
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
}
