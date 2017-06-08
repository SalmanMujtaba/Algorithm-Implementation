package LinkedList;

import java.util.Scanner;

public class ReturnKthToLast {
	Node head;
	int size = 0;

	static class Node {
		int data;
		Node next;
		Node(int d)  { data = d;  next=null; } // Constructor
	}

	public void printList()
	{
		Node n = head;
		while (n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;

		}	

	}
	
	public int size()
	{
		Node n = head;
		while(n!=null)
		{
			n = n.next;
			size++;
		}
		
		return size;
		
	}
	public int findElement(int x)
	{
		Node n = head;
		int temp = 1;
		while(temp<(x+1))
		{
			n = n.next;
			temp++;
		}
		return n.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReturnKthToLast llist = new ReturnKthToLast();

		llist.head = new Node(1);
		llist.head.next = new Node(4);
		llist.head.next.next = new Node(2);
		llist.head.next.next.next = new Node(3);
		llist.head.next.next.next.next = new Node(4);
		llist.head.next.next.next.next.next = new Node(4);
		llist.head.next.next.next.next.next.next = new Node(2);
		llist.head.next.next.next.next.next.next.next = new Node(3);
		llist.head.next.next.next.next.next.next.next.next = new Node(1);

		System.out.println("Original Linked List");
		llist.printList();
		System.out.println();
		
		Scanner s = new Scanner(System.in);
		int size = llist.size();
		System.out.println("Enter the kth element to last (between 1 and "+size+":)");
		int input = s.nextInt();
		int element = size-input;
				
		
		System.out.println("The the kth element to last is :"+llist.findElement(element));
		 
		
		
	}
}
