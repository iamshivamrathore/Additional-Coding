package graphs_trees;

import java.util.LinkedList;
import java.util.List;

public class ValidateBST {

	@SuppressWarnings("unchecked")
	static void inOrder(TreeNode<Integer> root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}

	static boolean validate(TreeNode<Integer> root) {
		List<Integer> list = new LinkedList<>();
		inOrder(root, list);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>list.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Integer> root = new TreeNode<Integer>(4);
		TreeNode<Integer> el = new TreeNode<Integer>(2);
		root.left = el;
		el = new TreeNode<Integer>(1);
		root.left.left = el;
		el = new TreeNode<Integer>(3);
		root.left.right = el;
		root.right = new TreeNode<Integer>(5);
		
		System.out.println(validate(root));
		
	}

}
