package graphs_trees;

public class Tree<T> {

	TreeNode<T> root;

	Tree() {
		root = null;
	}

	Tree(T data) {
		root = new TreeNode<T>(data);
	}
	

}
