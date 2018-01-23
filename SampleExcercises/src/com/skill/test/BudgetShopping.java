package com.skill.test;

/**
 * Given n as total budget you have, cost as the each bundle of notebook cost in ith store, 
 * quantity as number of notebooks in each bundle you have in ith store. Each store have unlimited bundle of notebooks.
 * Return the maximum number of notebook you can buy in n budget
 */   

public class BudgetShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = new int[] {10};//,10,20};
		int[] quanity = new int[] {1};//,1,1};
		int totalBooks = budgetShop(30, cost,quanity);
		System.out.println("Total purchase: "+totalBooks);
	}
	
	public static int budgetShop(int n, int[]cost, int[] quantity)
	{
		if(n<=0 ||cost==null||cost.length==0||quantity==null||quantity.length==0)
			return 0;
		
		int[] maxCount =new int[] {0};
		 dfs(n, cost, quantity, 0, 0, maxCount);
	        return maxCount[0];
		
		
	}
	private static void dfs(int n, int[] cost, int[] quantity, int index, int count, int[] maxCount) {
		System.out.println("i = "+index+" N(Total budget) "+n+" count "+count+" maxCount[0] "+maxCount[0]);
        if (n == 0 || index == cost.length) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }
        for (int i = 0; i <= n/cost[index]; i++) {
            dfs(n - i * cost[index], cost, quantity, index + 1, count + i * quantity[index], maxCount);
        }
    }

}
