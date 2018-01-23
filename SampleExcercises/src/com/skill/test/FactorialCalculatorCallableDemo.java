package com.skill.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FactorialCalculator implements Callable<Integer>
{
	
	private Integer number;
	public  FactorialCalculator() {
		// TODO Auto-generated constructor stub
	}
	public FactorialCalculator(Integer n)
	{
		this.number = n;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int result = 1;
		if((number ==0)||(number ==1))
		{
			result =1;
		}else
		{
			for(int i=2; i<=number; i++)
			{
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		System.out.printf("Result for Number %d is %d \n",this.number,result );
		return result;
	}
}

public class FactorialCalculatorCallableDemo {
	public static void main(String[] args) {
		ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		Random random = new Random();
		
		for(int i =0; i<4; i++)
		{
			Integer number = random.nextInt(10);
			FactorialCalculator fCal = new FactorialCalculator(number);
			Future<Integer> result = ex.submit(fCal);
			resultList.add(result);	
		}
		//System.out.println("Active count "+ex.getActiveCount());
		resultList.forEach(future ->{
			try {
				System.out.println("Future Result is: "+future.get()+" And task completed is " +future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		ex.shutdown();
		
		while(!ex.isTerminated()) {
			System.out.println("Completed all Threads");
		}

	}
	
}
