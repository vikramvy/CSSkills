package com.test.skills;

import java.util.Arrays;

//Count the number of prime numbers less than a non-negative number, n.
public class FizzBuzz {
	public static void main(String[] args) {
		
		
		System.out.println("Total Prime till 25 = "+countPrimes(2));
		
		
	}
	
	public static int countPrimes(int n)
	{
		//0 and 1 are not prime
		//2 is even prime
		//n = n-1;
		if(n<2) return 0;
		
		
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		primes[0]=primes[1]=false;
		for(int i=2;i<primes.length;i++) {
			if(primes[i]) {
				for(int j = 2; i*j<primes.length;j++)
				{
					primes[i*j]=false;
				}
			}
		}
		int count =0;
		for(int i=0;i<primes.length;i++)
		{ 
			if(primes[i])
				{
					System.out.println(i+" = is prime ");count++;
				}
		}
		return count;
	}
}
