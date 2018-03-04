package com.zyy.bean;

public class Answer {

//	CREATE TABLE `answertbl` (
//			  `id` int(11) NOT NULL AUTO_INCREMENT,
//			  `createTime` varchar(20) DEFAULT NULL,
//			  `systemMemberID` int(11) DEFAULT NULL,
//			  `questionID` int(11) DEFAULT NULL,
//			  `content` varchar(200) DEFAULT NULL,
//			  PRIMARY KEY (`id`),
//			  KEY `answer_question_fk_idx` (`questionID`),
//			  KEY `answer_systemmeber_fk_idx` (`systemMemberID`),
//			  CONSTRAINT `answer_question_fk` FOREIGN KEY (`questionID`) REFERENCES `questiontbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
//			  CONSTRAINT `answer_systemmeber_fk` FOREIGN KEY (`systemMemberID`) REFERENCES `systemmembertbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8
	
	private Integer id;
	private String createTime;
	private SystemMember sm;
	private Question q;
	private String content;
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
	public Question getQ() {
		return q;
	}
	public void setQ(Question q) {
		this.q = q;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
