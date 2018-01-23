package com.test.practice;

import java.util.Arrays;
import java.util.Optional;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = new int[] {4,3,1,5};
		int len = arr.length;
		if(len>0)
		{
			int temp =0;
			for(int i=0;i<arr.length/2;i++)
			{
				temp = arr[i];
				System.out.println(arr.length-1-i);
				arr[i]= arr[arr.length-1-i];
				arr[arr.length-1-i] = temp;
			}
		}
		System.out.println("Array reversed is "+Arrays.toString(arr));
		
		Optional<String> gender = Optional.of("MALE");
		String a1="Yes";
		String a2=null;
		System.out.println(gender.get());;
		System.out.println(gender);;
		System.out.println(gender.empty());
		
		System.out.println(Optional.ofNullable(a2));
		//System.out.println(Optional.of(a2));
		
	}
	
	

}
