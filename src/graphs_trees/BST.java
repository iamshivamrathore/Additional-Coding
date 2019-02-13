package graphs_trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BSTNode {
	BSTNode left;
	BSTNode right;
	int data;

	BSTNode(int data) {
		this.data = data;
		
	}

	public String toString() {
		return data + "";
	}
}

public class BST {

	BSTNode root;

	boolean find(BSTNode temp, int num) {

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

	void insert(BSTNode temp, int num) {
		if (temp.right == null && temp.left == null) {
			if (num > temp.data) {
				temp.right = new BSTNode(num);
			} else {
				temp.left = new BSTNode(num);
			}
		} else if (num > temp.data) {
			if (temp.right == null) {
				temp.right = new BSTNode(num);
			} else {
				insert(temp.right, num);
			}
		} else {
			if (temp.left == null) {
				temp.left = new BSTNode(num);
			} else {
				insert(temp.left, num);
			}
		}

	}

	void displayLevelOrder(BSTNode temp) {
		List<List> lists = new LinkedList<List>();

		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(temp);

		while (!queue.isEmpty()) {
			LinkedList<BSTNode> list = new LinkedList<>();

			while (!queue.isEmpty()) {
				list.add(queue.remove());
			}

			for (int i = 0; i < list.size(); i++) {
				BSTNode n = list.get(i);
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

		BSTNode bSTNode = new BSTNode(5);
		BST bst = new BST();
		bst.root = bSTNode;
		bst.root.left = new BSTNode(3);
		bst.root.left.left = new BSTNode(1);
		bst.root.left.right = new BSTNode(2);

		bst.root.right = new BSTNode(7);
		bst.root.right.left = new BSTNode(6);
		bst.root.right.right = new BSTNode(8);
		System.out.println(bst.find(bst.root, 2));
		bst.insert(bst.root, 2);
		System.out.println(bst.find(bst.root, 2));
		bst.displayLevelOrder(bst.root);

	}

}
