/*Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to end at the leaf, but it must go downwards
(traveling only from parent nodes to child nodes).*/


package graphs_trees;

public class PathsWithSum {

	static int count;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(1);
		root.right = new TreeNode(-1);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(2);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(2);

		paths(root, 5);
		System.out.println("Count : " + count);
	}

	@SuppressWarnings({ "unchecked" })
	static void paths(TreeNode<Integer> curr, int rem) {

		
		if(curr == null) {
			return ;
		}
		System.out.println("At : "+curr.data);
		rem = curr.data - rem;
		if (rem == 0) {
			System.out.println("Found");
			count++;
		}
		paths(curr.left, rem);
		paths(curr.right, rem);

	}

}
