package com.zyy.Thread;

public class MyTestThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		myThread1.run();
		Thread.currentThread().sleep(1 * 1000);
		myThread2.run();
	}
}



