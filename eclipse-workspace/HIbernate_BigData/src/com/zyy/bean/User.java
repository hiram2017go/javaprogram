package com.zyy.bean;

import java.sql.Blob;
import java.sql.Clob;

public class User {
	private int id;
	private Blob pic;
	private Clob resume;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	public Clob getResume() {
		return resume;
	}
	public void setResume(Clob resume) {
		this.resume = resume;
	}
	
}
