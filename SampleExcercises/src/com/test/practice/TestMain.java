package com.test.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {
	int []arr = new int[] {5,5,2,3,2};
	
		//Arrays.sort(arr);
	System.out.println("Odd times appearing integer is : "+ findIt(arr));
	
	}
	public static int findIt(int[] a)
	{
		int sum = 0;
		int size =a.length;
		int count =1;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	
		if(size>0)
		{
			for(int i =0; i<size;i++)
			{				
				
					if(map.containsKey(a[i]))
						{map.put(a[i],map.get(a[i])+1);}
					else
					{
						map.put(a[i], 1);
					}

			}
			map.forEach((k,v)->System.out.println("Key "+k+" Value "+v));
			for(Map.Entry<Integer, Integer> entry : map.entrySet())
			{
				if(entry.getValue()%2!=0)
				{
					sum = entry.getKey();
				}
			}
		}
		return sum;
	}
}
