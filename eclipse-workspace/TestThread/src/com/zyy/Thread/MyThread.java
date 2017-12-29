package com.zyy.Thread;

import java.util.Date;

public class MyThread extends Thread {

	public void run() {
		Date date = new Date();
		System.out.println("MyThread Run!"+ date);
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyThread myThread1 = new MyThread();
//		MyThread myThread2 = new MyThread();
//		myThread1.run();
//		myThread2.run();
//	}
}
