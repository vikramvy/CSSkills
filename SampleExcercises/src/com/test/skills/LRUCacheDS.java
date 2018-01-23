package com.test.skills;

import java.util.HashMap;
import java.util.Map;

//doubly linked list
class Node
{
	int key;
	int value;
	Node pre;
	Node next;
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}


public class LRUCacheDS {
	private int capacity;
	Map<Integer, Node> map = new HashMap<Integer,Node>();
	Node head = null;
	Node end = null;
	
	public LRUCacheDS(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		
	}
	public int get(int key) {
		
		if(map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	public void set(int key, int value) {
		
		
		if(map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}else
		{
			Node created  = new Node(key, value);
			if(map.size()>=capacity)
			{
				map.remove(end.key);
				remove(end);
				setHead(created);
			}else
			{
				setHead(created);
			}
			map.put(key, created);
		}
	}
	public void remove(Node n)
	{
		if(n.pre !=null)
		{
			n.pre.next = n.next;
			
		}else {
			head = n.next;
		}
		if(n.next!=null)
		{
			n.next.pre = n.pre;
		}else
		{
			end = n.pre;
		}
	}
	public void setHead(Node n)
	{
		n.next = head;
		n.pre = null;
		
		if(head !=null)
		{
			head.pre = n;
			
		}
		head = n;
		if(end == null)
		{
			end = head;
		}
	}
	
	public void printCahce()
	{
		System.out.print("HEAD-> ");
		 while(head != null) {
	            System.out.print(String.format(" [%s : %s |  %s  %s], ", head.key, head.value, 
	            		head.pre, head.next));
	            head = head.next;
	        }
	        System.out.print(" <- TAIL");
	        System.out.println();
		//System.out.println("head "+head.key+ " "+head.value);
	}
	public void printFrontBack(Node head){
        Node prev = null;
        while(head != null){
            System.out.print(head.key+" "+head.value + " | ");
            prev = head;
            head = head.next;
        }
        System.out.println();
       /* while(prev != null){
            System.out.print(prev.key+" "+prev.value + " | ");
            prev = prev.pre;
        }*/
    }
	
	public static void main(String args[])
	{
		
		System.out.println("Main function");
		LRUCacheDS l = new LRUCacheDS(5);
        
        l.set(1, 10);
        l.set(5, 12);
        l.set(7, 15);
        l.set(8, 16);
        l.set(9, 17);
        l.map.forEach((k,v)->System.out.print(k+" "+v+" |"));
        System.out.println();
        l.printFrontBack(l.head);
        l.get(5);
       
        l.printFrontBack(l.head);
        l.set(6, 14);
        l.printFrontBack(l.head);
       
	}
}
