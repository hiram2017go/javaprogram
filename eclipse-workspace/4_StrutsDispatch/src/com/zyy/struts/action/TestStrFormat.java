package com.zyy.struts.action;

public class TestStrFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = String.format("你好{0},你是{1}", new Object[] { "h","fuck"});
		System.out.println(result);
	}

}
