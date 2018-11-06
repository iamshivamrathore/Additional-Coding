package graphs_trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		
	}

	public String toString() {
		return data + "";
	}
}

public class BST {

	Node root;

	boolean find(Node temp, int num) {

		if (temp == null) {
			return false;
		}
		if (num == temp.data) {
			return true;
		}
		if (num > temp.data) {
			return find(temp.right, num);
		} else {
			return find(temp.left, num);
		}
	}

	void insert(Node temp, int num) {
		if (temp.right == null && temp.left == null) {
			if (num > temp.data) {
				temp.right = new Node(num);
			} else {
				temp.left = new Node(num);
			}
		} else if (num > temp.data) {
			if (temp.right == null) {
				temp.right = new Node(num);
			} else {
				insert(temp.right, num);
			}
		} else {
			if (temp.left == null) {
				temp.left = new Node(num);
			} else {
				insert(temp.left, num);
			}
		}

	}

	void displayLevelOrder(Node temp) {
		List<List> lists = new LinkedList<List>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(temp);

		while (!queue.isEmpty()) {
			LinkedList<Node> list = new LinkedList<>();

			while (!queue.isEmpty()) {
				list.add(queue.remove());
			}

			for (int i = 0; i < list.size(); i++) {
				Node n = list.get(i);
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}

			lists.add(list);
		}

		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node = new Node(5);
		BST bst = new BST();
		bst.root = node;
		bst.root.left = new Node(3);
		bst.root.left.left = new Node(1);
		bst.root.left.right = new Node(2);

		bst.root.right = new Node(7);
		bst.root.right.left = new Node(6);
		bst.root.right.right = new Node(8);
		System.out.println(bst.find(bst.root, 2));
		bst.insert(bst.root, 2);
		System.out.println(bst.find(bst.root, 2));
		bst.displayLevelOrder(bst.root);

	}

}
