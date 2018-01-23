package com.ds;

public class StackX {
	
	private int maxSize;
	private Long[] stackArray;
	private int top;

	public StackX(int s)
	{
		maxSize = s;
		stackArray = new Long[maxSize];
		top = -1;
	}
	
	public void push(Long j)
	{
		stackArray[++top] = j;
	}
	public Long pop()
	{
		return stackArray[top];
	}
	public Long peek()
	{
		return stackArray[top];
	}
	public boolean isStackEmpty()
	{
		return ( top == -1);
	}
	public boolean isStackFull()
	{
		return (top == maxSize-1); 
	}
	
	
}
