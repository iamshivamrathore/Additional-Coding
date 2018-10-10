/*Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8*/

package linkedlist;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Here");
		Node head = new Node(10);

		head.next = new Node(5);
		head.next.next = new Node(6);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(2);
		int el = 6;

		head.display();

		head = partition(head, el);

		head.display();

	}

	private static Node partition(Node head, int el) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			if (curr.num < el) {
				
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev;
			//	System.out.print("Smaller");
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;

	}

}
