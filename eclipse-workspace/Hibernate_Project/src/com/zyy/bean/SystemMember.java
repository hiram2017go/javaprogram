package com.zyy.bean;

public class SystemMember {
//	CREATE TABLE `systemmembertbl` (
//			  `id` int(11) NOT NULL AUTO_INCREMENT,
//			  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//			  `fullName` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//			  `privilege` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//			  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//			  PRIMARY KEY (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
	
	
	private Integer id;
	private String name;
	private String password;
	private String fullName;
	private String privilege;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
