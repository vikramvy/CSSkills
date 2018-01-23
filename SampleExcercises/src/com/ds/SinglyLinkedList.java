package com.ds;



public class SinglyLinkedList<E> {

	
	private static class ListNode<E>{
		private ListNode<E> next = null;
		private E element;
		
		public ListNode(E newData)
		{
			this.element = newData;	 
		}
		
		public E getData()
		{
			return this.element;
		}
		public void setNext(ListNode<E> next)
		{
			this.next = next;
		}
		public void setData(E newData)
		{
			this.element = newData;
		}
		public ListNode<E> getNext() {
			return this.next;
		}
	}
}
