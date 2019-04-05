package linkedlist;

import java.util.Stack;

public class AddLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);
		Node node2 = new Node(2);
		node.next = node2;

		Node node3 = new Node(7);
		Node node4 = new Node(8);
		Node node5 = new Node(9);
		node3.next = node4;
		node4.next = node5;

		Node resultNode = addTwoLists(node, node3);
		resultNode.display();
	}

	static int getLength(Node n) {
		int length = 0;
		while (n != null) {
			n = n.next;
			length++;
		}
		return length;
	}

	static Node zeroPad(Node n, int diff) {
		for (int i = 0; i < diff; i++) {
			Node newNode = new Node(0);
			newNode.next = n;
			n = newNode;
		}

		return n;
	}

	static Node addTwoLists(Node first, Node second) {
		int length1 = getLength(first);
		int length2 = getLength(second);

		int diff = Math.abs(length1 - length2);
		if (length1 > length2) {
			second = zeroPad(second, diff);
		} else if (length2 > length1) {
			first = zeroPad(first, diff);
		}

		first.display();
		second.display();

		Node headResult = null;
		Node result = null;
		Stack<Node> stack = new Stack<Node>();

		add(first, second, stack);
		// System.out.println(stack);

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			if (headResult == null) {
				headResult = node;
				result = headResult;
			} else {
				result.next = node;
				result = node;
			}
		}
		return headResult;
	}

	static int add(Node n1, Node n2, Stack<Node> stack) {

		if (n1 != null) {
			int sum = n1.data + n2.data + add(n1.next, n2.next, stack);
			Node node = new Node(sum % 10);
//			node.next = head;
//			head = node;

			stack.push(node);

			// push(head, node);

			return sum / 10;
		} else {
			return 0;
		}

	}

}
