package com.test.skills;

public class AnnualInterest {
	
	
	public static double calculateMonthlyPayment(double annualInterest, int principal, int tenure)
	{
		double rate= annualInterest/100.0;
		double monthlyInterest = rate/12.0;
		//amount = p(1+minterest)^termmontly;
		
		int termMonthly = 12*tenure;
		double amount = (principal*monthlyInterest)/
				(1-Math.pow(1+monthlyInterest, -termMonthly));
		return amount;
	}
	
	
	public static void main(String[] args)
	{
		double monthlyInterest = 5.75/1200;
		double monthlyPayment = 250000 * monthlyInterest / 
				(1 - 1 / Math.pow(1 + monthlyInterest, 15 * 12));
		System.out.println("Monthly Payment: "+monthlyPayment);
		
		System.out.println("calculate Monthly Payment: "+
		calculateMonthlyPayment(5.75, 250000, 15));
	}

}
