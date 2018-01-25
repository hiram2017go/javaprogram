package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zyy.bean.Point;

public class PointAction extends ActionSupport {
	
	private Point point;
	
	public Point getPoint() {
		return point;
	}


	public void setPoint(Point point) {
		this.point = point;
	}


	public String execute() throws Exception{
		
		System.out.println("x="+point.getX()+",y="+point.getY());
		return SUCCESS;
	}

}
