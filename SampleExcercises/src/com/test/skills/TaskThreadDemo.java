package com.test.skills;

public class TaskThreadDemo{

	public static void main(String[] args) {
		
		Runnable printA = new PrintChar('a',100);
		Runnable printB = new PrintChar('b',100);
		Runnable print100 = new PrintNum(100);
		
		Thread t1 = new Thread(printA);
		Thread t2 = new Thread(printB);
		Thread t3 = new Thread(print100);
		
		t1.start();
		t2.start();
		t3.run();
	}
	
	
}

class PrintNum implements Runnable{
	
	private int lastNum;
	
	public PrintNum() {
		// TODO Auto-generated constructor stub
	}
	
	public PrintNum(int n) {
		// TODO Auto-generated method stub
		lastNum = n;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =1; i<=lastNum;i++)
		{
			System.out.print(" "+i);
		}
	}
}



class PrintChar implements Runnable{
	
	private char charToPrint;
	private int times;
	
	
	public PrintChar() {
		// TODO Auto-generated constructor stub
	}
	public PrintChar(char c, int t)
	{
		charToPrint = c;
		times = t;
	}
	
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i < times; i++) {
			System.out.print(charToPrint);
		}
	}
}
