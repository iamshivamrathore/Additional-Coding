package graphs_trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Character> root = new TreeNode<Character>('A');
		root.left = new TreeNode<Character>('B');
		root.right = new TreeNode<Character>('C');

		root.left.left = new TreeNode<Character>('D');
		root.left.right = new TreeNode<Character>('E');

		root.right.right = new TreeNode<Character>('F');
		
		System.out.println(getLists(root));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static List<List> getLists(TreeNode<Character> root) {
		List<List> lists = new LinkedList<List>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			LinkedList<TreeNode<Character>> list = new LinkedList<>();

			while (!queue.isEmpty()) {
				list.add(queue.remove());
			}

			for (int i = 0; i < list.size(); i++) {
				TreeNode n = list.get(i);
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
			
			lists.add(list);
		}
		return lists;
	}

}
