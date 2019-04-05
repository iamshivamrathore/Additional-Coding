/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
Input: the node c from the linked list a - >b- >c - >d - >e- >f
Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f*/

package linkedlist;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(5);
		Node node4 = new Node(25);
		Node node5 = new Node(20);

		Node headNode = node;
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		headNode.display();

		delete(node3);
		headNode.display();
	}

	private static void delete(Node node3) {
		node3.data = node3.next.data;
		node3.next = node3.next.next;
	}

}
