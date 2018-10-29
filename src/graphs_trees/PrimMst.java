package graphs_trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMST {

	int vertices;

	static class Node {
		int vertex;
		int weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public String toString() {
			return vertex + "(" + weight + ")  ";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			if (vertex != other.vertex)
				return false;

			return true;
		}

	}

	Map<Integer, List<Node>> graph;

	PrimMST(int n) {
		graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<Node> list = new ArrayList<>();
			graph.put(i, list);
		}

		vertices = n;
	}

	void addEdge(int source, int dest, int weight) {
		Node node = new Node(source, weight);
		graph.get(dest).add(node);
		node = new Node(dest, weight);
		graph.get(source).add(node);
	}

	void MST(int source) {
		System.out.println("MAP : " + graph);
		List<Node> MST = new LinkedList<>();
		Queue<Node> minHeap = initializeMinHeap(source);

		boolean visited[] = new boolean[vertices];
		int distance[] = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		Node parent = null;
		Node node = null;
		Map<Integer, Integer> ans = new HashMap<>();
		while (!minHeap.isEmpty()) {
			System.out.println("MinHeap : " + minHeap);
			parent = node;
			node = minHeap.remove();
			try {
				ans.put(parent.vertex, node.vertex);
			} catch (Exception e) {
				ans.put(0, 0);
			}
			System.out.println("Map : " + ans);
			System.out.println("Polled : " + node);
			System.out.println();
			MST.add(node);
			visited[node.vertex] = true;

			List<Node> neighbours = graph.get(node.vertex);

			// Iterator<Node> it = neighbours.iterator();

			for (int i = 0; i < neighbours.size(); i++) {
				Node neighbour = neighbours.get(i);

				if (!visited[neighbour.vertex] && distance[neighbour.vertex] > neighbour.weight) {
					System.out.println("Before Removing: " + minHeap.peek() + "from : " + minHeap);
					distance[neighbour.vertex] = neighbour.weight;
					System.out.println(minHeap.remove(neighbour));
					Node n = new Node(neighbour.vertex, neighbour.weight);

					System.out.println("Before adding: " + minHeap);
					minHeap.add(n);
					System.out.println("After adding: " + minHeap);
					System.out.println("Updated : " + neighbour);
					System.out.println("\n");

				}
			}
		}

		System.out.println("MST : " + MST);
		System.out.println("Map : " + ans);
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
		// TODO Auto-generated method stub

		PrimMST graph = new PrimMST(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);
		graph.MST(0);
	}

}
