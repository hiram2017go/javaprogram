package com.zyy.converter;

import java.util.Map;

import com.zyy.bean.Point;

import ognl.DefaultTypeConverter;

public class PointConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map map, Object obj, Class toType) {
		
		if(toType == Point.class) {
			String[] strs = (String[])obj;
			String[] xy = strs[0].split(",");
			
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			
			Point p = new Point();
			p.setX(x);
			p.setY(y);
			
			return p;
		}else if(toType == String.class) {
			Point point = (Point)obj;
			return "["+point.getX()+","+point.getY()+"]";
		}
		
		return null;
	}

	
}
