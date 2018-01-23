package com.test.practice;

public class PerfectArray {
	public static boolean isPerfectArray(int[] arr, int n)
	{
		boolean result = false;
		
		int i =1;
		while(arr[i]>arr[i-1] && i<n)
		++i;
		while(arr[i] ==arr[i-1] && i<n)
		++i;
		while(arr[i]<arr[i-1]&& i<n)
			++i;
		
		if(i==n)
			result = true;
		
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,3,3,2,1};
		System.out.println("size of array "+arr.length);
		int size = arr.length-1;
		System.out.println("Array is perfect : "+isPerfectArray(arr,size));
	}

}
