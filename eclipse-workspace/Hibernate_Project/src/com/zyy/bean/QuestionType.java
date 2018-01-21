package com.zyy.bean;

public class QuestionType {

//	CREATE TABLE `questiontypetbl` (
//			  `id` int(11) NOT NULL AUTO_INCREMENT,
//			  `name` varchar(20) DEFAULT NULL,
//			  PRIMARY KEY (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8
	
	private Integer id;
	private String name;
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
}
