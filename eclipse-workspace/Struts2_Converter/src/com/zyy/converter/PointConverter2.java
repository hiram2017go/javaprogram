package com.zyy.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.zyy.bean.Point;


public class PointConverter2 extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map map, String[] obj, Class arg2) {
		// TODO Auto-generated method stub
		String[] xy = obj[0].split(",");
		
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		
		Point p = new Point();
		p.setX(x);
		p.setY(y);
		
		return p;
	}

	@Override
	public String convertToString(Map map, Object obj) {
		Point point = (Point)obj;
		return "("+point.getX()+","+point.getY()+")";
	}

	
}
