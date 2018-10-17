package graphs_trees;

public class MinimalTree {

	int arr[];
	TreeNode<Integer> root;

	void initialize(int n) {
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		root = new TreeNode<>(arr[n / 2]);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalTree m = new MinimalTree();
		m.initialize(11);
		m.create();
		m.display();
	}

	private void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying");
		inOrder(root);
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	void inOrder(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);

		System.out.print(node.data + " ");
		inOrder(node.right);

	}

	void create() {
		boolean visited[] = new boolean[arr.length];

		int pos = arr.length / 2;
		visited[arr.length / 2] = true;
		
		System.out.println();
		createTree(visited, root, pos);

		
	}

	private void createTree(boolean[] visited, TreeNode<Integer> curr, int i) {
		// TODO Auto-generated method stub
	//	System.out.println("Display");
		display();
		if (i >= 2 && !visited[i - 2]) {
			System.out.println("1 : "+arr[i-2]);
			TreeNode<Integer> node = new TreeNode<Integer>(arr[i - 2]);
			curr.left = node;
			visited[i - 2] = true;
			createTree(visited, node, i - 2);

		} else if (i >= 1 && !visited[i - 1]) {
			System.out.println("2 :"+arr[i-1]);
			TreeNode<Integer> node = new TreeNode<Integer>(arr[i - 1]);
			curr.left = node;
			visited[i - 1] = true;
			createTree(visited, node, i - 1);
		}

		if (i <= arr.length - 3 && !visited[i + 2]) {
			System.out.println("3 : "+arr[i+2]);
			TreeNode<Integer> node = new TreeNode<Integer>(arr[i + 2]);
			curr.right = node;
			visited[i + 2] = true;
			createTree(visited, node, i + 2);
		} else if (i <= arr.length - 2 && !visited[i + 1]) {
			System.out.println("4 : "+arr[i+1]);
			TreeNode<Integer> node = new TreeNode<Integer>(arr[i + 1]);
			curr.right = node;
			visited[i + 1] = true;
			createTree(visited, node, i + 1);
		}
	}

}
