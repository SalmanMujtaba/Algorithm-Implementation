import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDupFromLinkedL {
	Node head;

	static class Node {
		int data;
		Node next;
		Node(int d)  { data = d;  next=null; } // Constructor
	}

	HashSet dup= new HashSet();
	public void remove()
	{
		Node cur = head;
		Node prev= null;

		try
		{

			while(cur!=null)
			{
				if(dup.contains(cur.data))
				{
					if(cur.next == null)
					{
						prev.next = null;
					}
					prev.next = cur.next;
				}

				else
				{
					dup.add(cur.data);
					prev = cur;
				}

				cur = cur.next;

			}
		}

		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		System.out.println("List after deleting the duplicates from the list");
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

		RemoveDupFromLinkedL llist = new RemoveDupFromLinkedL();

		llist.head = new Node(1);
		llist.head.next = new Node(4);
		llist.head.next.next = new Node(2);
		llist.head.next.next.next = new Node(3);
		llist.head.next.next.next.next = new Node(4);
		llist.head.next.next.next.next.next = new Node(4);
		llist.head.next.next.next.next.next.next = new Node(2);
		llist.head.next.next.next.next.next.next.next = new Node(3);
		llist.head.next.next.next.next.next.next.next.next = new Node(1);

		System.out.println("Original Unordered Linked List");
		llist.printList();
		System.out.println();
		llist.remove();
	}
}
