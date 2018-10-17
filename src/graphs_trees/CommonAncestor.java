/*4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
*/

package graphs_trees;

public class CommonAncestor {

	TreeNode<Integer> root;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	void initialize() {
		root = new TreeNode<Integer>(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
	}

	@SuppressWarnings("unchecked")
	TreeNode<Integer> common(TreeNode<Integer> node, int n1, int n2) {
		if (node == null) {
			return node;
		}

		if (node.data == n1 || node.data == n2) {
			return node;
		}

		TreeNode<Integer> leftCommon = common(node.left, n1, n2);
		TreeNode<Integer> rightCommon = common(node.right, n1, n2);

		if (leftCommon != null && rightCommon != null) {
			return node;
		}

		return (leftCommon == null) ? rightCommon : leftCommon;
	}

	void find(int n1, int n2) {
		System.out.println("Common ancestor is : " + common(root, n1, n2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonAncestor ob = new CommonAncestor();
		ob.initialize();
		ob.find(2,4);

	}

}
