package com.zyy.spring;

public class UDisk implements USB {

	@Override
	public void read() {
		System.out.println("��Ӳ�̶�������");
		
	}

	@Override
	public void write() {
		System.out.println("��Ӳ��д...");
	}

}
