package com.test.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * @author vvyaway4
 * remove duplicates o(n) and o(1) and o(n) and space 0(n)
 * find the first duplicate number for which the second occurrence has the minimal index. o(n) and o(1)
 *
 */
public class DuplicateArrays {
	
	public static void main(String[] args) {
		
		int[] a= new int[] {2, 3, 3, 1, 5, 2};
		firstDuplicate(a);
		
		//int firstDuplicateElement = firstDuplicate(a);
		//System.out.println("First Duplicate Element is: "+firstDuplicate(a));//firstDuplicateElement);
		
		
	}
	//you cannot sort the array as you will lose the index setup as given
	private static void firstDuplicate(int[] a) {
		// TODO Auto-generated method stub
		//read the array find the duplicate and as soon as you find the duplicate 
		//store it 
		
		List<Integer> numList = Arrays.stream(a).boxed().collect(Collectors.toList());
		Set<Integer> numberSet = new LinkedHashSet<Integer>(numList); //new Set<Integer>(values);
		numberSet.forEach((e)->System.out.print(e+" "));

	
		/*for(int i=0; i<a.length;i++)
		{
			
			if(a[Math.abs(a[i])] >= 0)
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			else
				System.out.print(Math.abs(a[i])+ " ");
		}
		*/
		//
	}
	
}