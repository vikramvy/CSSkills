package com.test.skills;
class TaskClass1 implements Runnable{
	
	public TaskClass1() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Task class run method");
	}
	

}
public class TaskClient {
	
	
	public static void main(String[] args) {
	

		TaskClass1 task = new TaskClass1();
		Thread thread =  new Thread(task);
		thread.start();
		System.out.println("thread started: "+thread.getState()+" "+thread.getName());
		thread.interrupt();
		System.out.println("thread started: "+thread.getState()+" "+thread.getName());
	}
	

}
