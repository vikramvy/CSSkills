package com.skill.test;

import java.util.Scanner;

class PrintStringCounter implements Runnable
{
	private int counterLimit;
	public PrintStringCounter(int counterLimit)
	{
		this.counterLimit = counterLimit;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<this.counterLimit;i++)
		{
			System.out.println(i);
		}
	}
	
}

public class StringsTeset {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.out.println("Print counter");
	Scanner sc = new Scanner(System.in);
	int counterLimit = sc.nextInt();
	sc.close();
	PrintStringCounter p = new PrintStringCounter(counterLimit);
	Thread t = new Thread(p);
	t.start();
	System.out.println("Status of counter Thread : "+t.getState());
	t.join();
	System.out.println("Terminating Main");
}

}




