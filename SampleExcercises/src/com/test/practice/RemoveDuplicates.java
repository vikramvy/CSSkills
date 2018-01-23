package com.test.practice;

public class RemoveDuplicates {
public static void main(String[] args) {
	int[] arr = new int[] {1,1,2};
	int newSize = removeDuplicates(arr);
	System.out.println("SIze: "+newSize);
}
	
	
	public static int removeDuplicates(int[] nums) {
        
		int len = nums.length;
		if(len==0)return 0;
		if(len==1) return len;
		int temp = 0;
		for(int i=0;i<len-1;i++)
		{
			if(nums[i]!=nums[i+1])
				nums[temp++] = nums[i];
		}
		nums[temp++] = nums[len-1];
		for(int i=0;i<temp;i++)
		{
			System.out.println(nums[i]);
		}
		return temp;
	}
}
/**

a[i] == a[i+1] = duplicate
	temp = a[i+1];
	a[i] = temp;
	


**/