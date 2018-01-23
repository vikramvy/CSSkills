package com.skill.test;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {

	public static void main(String[] args) {
		
		int[] nums= new int[] {2, 7, 11, 15};
		int target = 9;
		int[] result = new int[2];
		//Arrays.sort(nums);
		result = twoSum(nums, target);
		for(int i=0; i<result.length;i++)
		{
			System.out.print(" "+result[i]);
		}
		
	}
	
	public static int[] twoSum(int[] nums, int target)
	{
		if(nums ==null || nums.length<2)
		return new int[]{0,0};
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length;i++)
		{
			if(map.containsKey(nums[i]))
			{	return new int[] {map.get(nums[i]),i};}
			else {
				map.put(target-nums[i], i);
			}
		}
		return new int[] {0,0};
	}
	

	

}
