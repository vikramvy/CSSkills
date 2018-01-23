package com.ds;


public class SimpleLinkedList {
	
	
	private static class Node{
		int data;
		Node next;
		public Node(int data, Node n)
		{
			this.data= data;
			this.next = n;
			
		}
		public int getElement() {return data;}
		public Node getNext(){return next;}
		public void setNext(Node n) {next = n;}
	}
	Node head = null;
	Node tail = null;
	private int size = 0;
	public int size() {return size;}

	public boolean isEmpty() {
		return size ==0;
	}
	public void addFirstNode(int data)
	{
		head = new Node(data, head);
		if(size==0)
			tail = head;
		size++;
	}
	public void addLast(int data)
	{
		Node newNode = new Node(data, null);
		if(isEmpty())
		{
			head = newNode;
		}else {
			tail.setNext(newNode);
			
		}
		tail = newNode;
		size++;
		
	}
	
	public void insertNode(int index, int data)
	{
		if(index==0) addFirstNode(data);
		else if(index>=size) addLast(data);
		else {
			Node current = head;
			for(int i=1; i<index;i++)
				current = current.next;
			Node temp = current.next;
			current.next = new Node(data,current.next);
			(current.next).next = temp;
			size++;
		}
		
	}
	public int removeFirst()
	{
		if(size==0)return -1;
		else{
			Node temp = head;
			head = head.next;
			size--;
			if(head == null)tail = null;
			return temp.getElement();
		}
		
		
		
	}
	//remove 
	//1->2->3->END
	public void removeNode(int data)
	{
		Node current = head;
		if(head==null)
		{
			System.out.println("Error: List is empty");
		}
		while(head!=null)
		{
			if(head.data == data)
			{
				
			}
		}
		
		int i = 1;
		String s = String.valueOf(i);
	}
	
	public void printList()
	{
		Node n = head;
		while(n!=null)
		{
			System.out.print(n.data+" -> ");
			n=n.next;
			if(n==null) {System.out.print("End");}
		}
		System.out.println("\nSize of List: "+size+"\n");
	}
	
	
	
	public static void main(String args[])
	{
		
		SimpleLinkedList linkedList = new SimpleLinkedList();
		linkedList.addFirstNode(4);
		linkedList.printList();
		linkedList.addLast(7);
		linkedList.printList();
		
		linkedList.insertNode(1, 8);linkedList.printList();
	}
	
	
	/*public add
	
	public Node getNode(int index)
	{
		Node current = head;
		
	}
	
	
	public void addHead(int data)
	{
		Node newHead = new Node(data);
		newHead.next=this.head;
		head = newHead;
		size++;
	}
	public void insertNode(Node positionNode, int data)
	{
		if(positionNode==null)
		{
			System.out.println("Exisiting PositioNode cannot be Null");
		}
		Node newNode = new Node(data);
		newNode.next = positionNode.next;
		positionNode.next = newNode;
		
		
	}
	
	public void addTailNode(int data)
	{
		Node newTail = new Node(data);
		newTail.next = null;
		Node current = head;
		while(current!=null) {
			current = current.next;
			if(current.next == null)
			{
				break;
			}	
		}
		current.next = newTail;
		size++;
		
	}
	
	*/
}
