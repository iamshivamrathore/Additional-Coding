package graphs_trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TestClass {

	int vertices;

	class Node {
		int vertex;
		int weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		Node(int vertex) {
			this.vertex = vertex;
			this.weight = 0;
		}

		public String toString() {
			return vertex + " (" + weight + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + vertex;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (vertex != other.vertex)
				return false;

			return true;
		}

		private TestClass getOuterType() {
			return TestClass.this;
		}

	}

	Map<Integer, List<Node>> graph;

	TestClass(int vertices) {
		this.vertices = vertices;

		graph = new HashMap<Integer, List<Node>>();
		for (int i = 0; i < vertices; i++) {
			List<Node> list = new ArrayList<>();
			graph.put(i, list);
		}
	}

	int[] findTestClass(int source) {
		Queue<Node> minHeap = initializeMinHeap(source);
		int distance[] = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;

	 	System.out.println("Generated minHeap : " + minHeap);
		Set<Integer> visited = new HashSet<>();
		visited.add(source);
		while (!minHeap.isEmpty()) {

			Node n = minHeap.poll();
			visited.add(n.vertex);
	 		System.out.println("\n\nPopped from minHeap : " + n);

			List<Node> neighbours = graph.get(n.vertex);
	 		System.out.print("Neighbours are : " + neighbours);

			for (int i = 0; i < neighbours.size(); i++) {
				Node neighbour = neighbours.get(i);
	 			System.out.print("\tNeighbour : " + neighbour);

				if (!visited.contains(neighbour.vertex)
						&& distance[neighbour.vertex] > distance[n.vertex] + neighbour.weight) {

	 				System.out.println("Remove : " + minHeap.remove(neighbour));
					distance[neighbour.vertex] = distance[n.vertex] + neighbour.weight;

					Node temp = new Node(neighbour.vertex, distance[neighbour.vertex]);
					minHeap.add(temp);
	 				System.out.print(
	 						"\tUpdating : " + neighbour.vertex + " new distance : " + distance[neighbour.vertex]);
					  if(distance[neighbour.vertex] < min_dist) {
					  min_dist = distance[neighbour.vertex];
					  min = neighbour;
					  }
				}

			}
 			System.out.println("\nMinHeap : " + minHeap);

		}

 		System.out.println("\n\n\nResult : ");
 		for (int i = 0; i < vertices; i++) {
 			System.out.print(i + " " + distance[i] + "\t");
 		}
		
		return distance;
	}

	void addEdge(int source, int dest, int weight) {
		Node n = new Node(dest, weight);
		graph.get(source).add(n);
	}

	void addEdge(int source, int dest) {
		Node n = new Node(dest, 1);
		graph.get(source).add(n);
	}

	Queue<Node> initializeMinHeap(int source) {
		Queue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node ob1, Node ob2) {
				if (ob2.weight < ob1.weight) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		for (int i = 0; i < vertices; i++) {
			Node n;
			if (i != source) {
				n = new Node(i, Integer.MAX_VALUE);

			} else {
				n = new Node(i, 0);
			}

			minHeap.add(n);
		}

		return minHeap;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			TestClass ob = new TestClass(n);
			for (int j = 0; j < m; j++) {
				ob.addEdge(scanner.nextInt()-1, scanner.nextInt()-1);
			}

			int ans[] = ob.findTestClass(0);
			System.out.println(ans[n-1]);
		}
		scanner.close();

	}
}