package com.zyy.thread;

class Thread1 extends Thread{
	private String name;
	public Thread1(String name) {
		super(name);
		this.name =name;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" 线程开始运行");
		for(int i = 0; i< 5; i++) {
			 System.out.println("子线程 "+name + " 运行 : " + i);  
			try {
				sleep((int)Math.random() * 10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束");
	}
}

public class testjava{
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始");
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
		
		//加.join()，确保子线程结束后主线程再结束
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
	}
}
