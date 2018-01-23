package com.algo.search;

import java.util.Arrays;

public class BinarySearchAlgo {

	public static int binarySearch(int[] arr, int size, int element)
	{
		int lowerBound = 0;
		int upperBound = size-1;
		int midCurrentIndex ;
		
		while(lowerBound<= upperBound)
		{
			
			midCurrentIndex = (lowerBound+upperBound)/2;
			if(element == arr[midCurrentIndex])
				return midCurrentIndex;
			
			if(arr[midCurrentIndex]< element)
			{
				lowerBound = midCurrentIndex+1;
			}else
			{
				upperBound = midCurrentIndex-1;
			}
		}
		return -1;
		
	}
	
	public static int binarySearchRecursive(int a[], int start, int end, int target)
	{
		int middle = (start+end)/2;
		if(start>end) return -1;
		if(target==a[middle]) {
	        return middle;
	    } else if(target<a[middle]) {
	        return binarySearchRecursive(a, start, middle - 1, target);
	    } else {
	        return binarySearchRecursive(a, middle + 1, end, target);
	    }
		
	}
	
	
	public static void main(String[] args)
	{
		
		int size=0;
		int[] arr  = new int[] { 4,5,3,55,232};
		/*System.out.println("Input Array Size : ");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		if(size <= 0)
			System.out.println(" Size of Array should be greater than ZERO ");
		arr = new int[size];
		System.out.print("Input Elements of Array: ");
		for(int i=0; i<size; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("size of array "+arr.length);
		for(int i=0; i<size; i++)
		{
			System.out.print(arr[i]+" ");
		}
		Arrays.sort(arr);
		System.out.println("Enter the Element to be searched in array ");
		int element = sc.nextInt();
		sc.close();*/
		Arrays.sort(arr);
		int result = binarySearchRecursive(arr, 0, arr.length-1, 55);
				//binarySearch(arr, arr.length, 55);
		
		if(result<0)
			System.out.println("Element not found");
		else
			System.out.format("element 55 is found at index %d",result);
	}
}
