package com.zyy.thread;

class Thread1 extends Thread{
	private String name;
	public Thread1(String name) {
		super(name);
		this.name =name;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" �߳̿�ʼ����");
		for(int i = 0; i< 5; i++) {
			 System.out.println("���߳� "+name + " ���� : " + i);  
			try {
				sleep((int)Math.random() * 10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " �߳����н���");
	}
}

public class testjava{
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "���߳����п�ʼ");
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
		
		//��.join()��ȷ�����߳̽��������߳��ٽ���
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
		
		System.out.println(Thread.currentThread().getName() + "���߳����н���!");
	}
}
