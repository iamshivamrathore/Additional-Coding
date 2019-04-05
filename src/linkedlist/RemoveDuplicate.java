/*Remove Dups: Write code to remove duplicates from an unsorted linked list.*/

package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

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
		remove(headNode).display();
	}

	static Node remove(Node hNode) {
		Node tempNode = hNode;
		Set<Integer> set = new HashSet<>();

		Node newTempNode = new Node(hNode.data);
		Node newHeadNode = newTempNode;
		tempNode = tempNode.next;
//		newHeadNode.display();

		// Node head = hNode;
		// tempNode=tempNode.next();
		while (tempNode != null) {
			if (!set.contains(tempNode.data)) {
				newTempNode.next = new Node(tempNode.data);
				newTempNode = newTempNode.next;
				set.add(tempNode.data);
			}
			System.out.println("Set : " + set);
			tempNode = tempNode.next;
			newHeadNode.display();
		}

		return newHeadNode;
	}

}
