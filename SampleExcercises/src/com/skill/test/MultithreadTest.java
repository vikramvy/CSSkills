package com.skill.test;

import java.util.concurrent.TimeUnit;

import javax.management.InstanceNotFoundException;

class SleepTest implements Runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println("Slept - waiting" + Thread.currentThread().getName());
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("value of I "+i);
		}
	}
}

class JoinThreadTest extends Thread
{
	public void run()
	{
		for(int i =1; i<=5;i++)
		{
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println("Join Thead value of I "+i);
		}
	}
}
class MultiThreadDemo extends Thread
{
	public void run()
	{
		System.out.println("Thread "+Thread.currentThread().getId()+" is Running");
	}
}

public class MultithreadTest {

	public static void main(String[] args) {
		
		/*SleepTest sTest1 = new SleepTest();
		SleepTest sTest2 = new SleepTest();
		Thread t1 = new Thread(sTest1);
		Thread t2 = new Thread(sTest2);
		t1.start();
		t2.start();*/
		
		JoinThreadTest jT1 = new JoinThreadTest();
		JoinThreadTest jT2 = new JoinThreadTest();
		JoinThreadTest jT3 = new JoinThreadTest();
		jT1.start();
		try {
			jT1.join();
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		jT2.start();
		jT3.start();
	}
}
//Main code earlier version comment
/*System.out.println("Main Thread "+Thread.currentThread().getName());
for(int i=1;i<=10; i++)
{	MultiThreadDemo mt = new MultiThreadDemo();
	mt.start();
}

Thread t = new Thread (new Runnable () {
	public void run()
	{
		System.out.println("Thread is Running "+Thread.currentThread().getName());
	}
});

Runnable task2 =()->{System.out.println("Lambda Runnable "+Thread.currentThread().getName());};
t.start();
Thread tT2 = new Thread(task2);
		tT2.start();
System.out.println(" Lambda " +tT2.getState());
try {
	tT2.join();
	t.join();
	
	
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Terminating Main " +Thread.currentThread().getName());*/
