/* 
Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node. 
*/
package LinkedList;

public class DeleteMiddleNode {

	Node head;


	static class Node
	{
		int data;
		Node next;

		Node(int a)
		{
			this.data = a;
			next = null;

		}
	}

	public void deleteFromMiddle(Node a)
	{
		Node temp = a.next;
        a.data = temp.data;
        a.next = temp.next;
        temp = null;
		printList();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeleteMiddleNode llist = new DeleteMiddleNode();

		llist.head = new Node(1);
		Node second = new Node(2);
		llist.head.next = second;
		second.next = new Node (3);
		second.next.next = new Node(4);
		
		System.out.println("Original List");
		llist.printList();
		System.out.println();
		
		System.out.println("List after deleting "+second.data);
		llist.deleteFromMiddle(second);
		


	}

}
