package graphs_trees;

class Node {
	int vertex;
	int weight;

	Node(int v, int w) {
		vertex = v;
		weight = w;
	}

	@Override
	public String toString() {
		return vertex + "(" + weight + ")";
	}

}