package com.test.skills;

import javax.xml.parsers.DocumentBuilderFactory;

public class DoubleLinkedList {

		
		/** Nested Node class **/
		private static class Noded{
			private int data;
			private Noded prev;
			private Noded next;
			
			public Noded(int data, Noded p, Noded n)
			{
				this.data = data;
				this.prev = p;
				this.next = n;
			}
			
			public int getElement() {return data;}
			public Noded getPrev() {return prev;}
			public Noded getNext() {return next;}
			public void setPrev(Noded p)
			{prev = p;}
			public void setNext(Noded n) {next = n;}
		} //end of nested Node class
		
		//variables for doubly Linked List
		private Noded head;
		private Noded tail;
		private int size =0;
		
		public DoubleLinkedList()
		{
			head = new Noded(-1,null,null);
			tail = new Noded(-1,head,null);
			head.setNext(tail);
			
		}
		public int first()
		{return head.getNext().getElement();}
		public int last()
		{return tail.getPrev().getElement();}
		
}
