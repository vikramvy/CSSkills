package com.test.skills;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesInArray {
	
	public static boolean containsDuplicate(int[] array)
	{
		boolean result = false;
		if(array == null || array.length <2)
			return false;
		
		int l = array.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<l;i++)
		{
			if(set.contains(array[i]))
					{
						return true;
					}else
			{	set.add(array[i]);
			
			}
			
		}
		return result;
	}
	
	  public static int singleNumber(int[] nums) {
		  
		  		int result = 0;
		  		for(int i =0; i<nums.length;i++)
		  		{
		  			result ^= nums[i];
		  		}
		  		return result;
	  }
	
	public static void main(String[] args)
	{
		int[] array = new int[] {1,2,3,2,1};
		//System.out.println("Array contains duplicate "+containsDuplicate(array));
		System.out.println("Array contains lonely element "+singleNumber(array));
	}
}
