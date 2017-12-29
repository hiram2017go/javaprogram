package com.zyy.Thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("unchecked")
public class Test {

	public static void main(String[] args) throws ExecutionException, InterruptedException{
		// TODO Auto-generated method stub
		System.out.println("--------����ʼ����----------");
		Date date1 = new Date();
		
		int taskSize = 5;
		//����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//��������з���ֵ������
		List<Future> list = new ArrayList<Future>();
		for(int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " ");
			//ִ�����񲢻�ȡFuture����
			Future f = pool.submit(c);
			list.add(f);
		}
		//�ر��̳߳�
		pool.shutdown();
		
		//��ȡ���в�����������н��
		for(Future f : list) {
			//��Future�����ϻ�ȡ����ķ���ֵ�������������̨
			System.out.println(">>>"+f.get().toString());
		}
		
		Date date2 = new Date();
		System.out.println("---------�������н���----------����������ʱ��["+(date2.getTime()-date2.getTime())+"]����");
	}

}

class MyCallable implements Callable<Object>{
	private String taskNum;
	
	MyCallable(String taskNum){
		this.taskNum = taskNum;
	}
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>"+taskNum+"��������");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>"+taskNum+"������ֹ");
		return taskNum + "���񷵻����н������ǰ����ʱ��["+time+"]����";
	}
	
}