package com.zyy.testinvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class test {

	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		Class cls;
		try {
			cls = Class.forName("com.zyy.testinvoke.Person");
			
			System.out.println(cls);
			
			try {
				Person per = (Person) cls.newInstance();
				
				try {
					Method m = cls.getMethod("testStr", String.class);
					Object obj = m.invoke(per, "123123");
					
					System.out.println(obj+"sdfsdfsdf");
					
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
