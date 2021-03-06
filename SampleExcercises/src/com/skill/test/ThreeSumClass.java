package com.skill.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClass {
public static void main(String[] args) {
		
		int[] nums= new int[] {-1,0, 1, 2, -1, -4};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = threeSum();
		for(int i=0;i<result.size();i++)
		{
			List<Integer> l = result.get(i);
			l.forEach(p->System.out.println(p));
		}
	}

	public static List<List<Integer>> threeSum()
	{
		List<List<Integer>> result =  new ArrayList<List<Integer>>();
		int[] nums= new int[] {-1,0, 1, 2, -1, -4};
		if(nums == null || nums.length<3)
			return result;
		for(int i=0; i<nums.length-2; i++){
	        if(i==0 || nums[i] > nums[i-1]){
	            int j=i+1;
	            int k=nums.length-1;
	 
	            while(j<k){
	                if(nums[i]+nums[j]+nums[k]==0){
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[k]);
	                    result.add(l);
	 
	                    j++;
	                    k--;
	 
	                    //handle duplicate here
	                    while(j<k && nums[j]==nums[j-1])
	                        j++;
	                    while(j<k && nums[k]==nums[k+1])
	                        k--;
	 
	                }else if(nums[i]+nums[j]+nums[k]<0){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }
	 
	    }
	 
		
		return result;
	}
}
