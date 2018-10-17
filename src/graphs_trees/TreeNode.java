package graphs_trees;

public class TreeNode<T> {

	TreeNode left;
	TreeNode right;
	T data;
	
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public String toString() {
		return data.toString();
	}
	
	void insertToLeft(T data){
		TreeNode<T> node = new TreeNode<T>(data);
		this.left = node;
	}
	void insertToRight(T data){
		TreeNode<T> node = new TreeNode<T>(data);
		this.right= node;
	}
}
