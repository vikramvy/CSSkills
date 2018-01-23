package com.test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonnaciEven {
	
	
	public static int printFiboEvenSum(int n)
	{
		int s1 =1;
		int s2 = 1;
		int temp = s1;
		System.out.print("Series is :" +s1);
		List<Integer> l = new ArrayList<Integer>();
		for(int i =1; i<n; i++)
		{
			s1 = s2;
			s2 =temp;
			temp = s1+s2;
			if((temp%2)==0)
			{
				l.add(temp);
			}
			
			System.out.print(","+ temp);
		}
//		l.forEach(i->System.out.println("\n"+i+","));
		int[] arr = l.stream().mapToInt(i->i).toArray();
		int sum = Arrays.stream(arr).sum();
		return sum;
		
		
	}
	public static void main(String[] args) {
			
		System.out.println("Fibonacci Series ");
		System.out.println("\nSum of all Even Number numbers in Fib is "+printFiboEvenSum(10));
		
	
	}

}
