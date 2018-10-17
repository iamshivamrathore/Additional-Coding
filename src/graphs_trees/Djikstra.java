package graphs_trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Djikstra {

	int vertices;

	static class Node {
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
	}

	Map<Integer, List<Node>> graph;

	Djikstra(int vertices) {
		this.vertices = vertices;

		graph = new HashMap<Integer, List<Node>>();
		for (int i = 0; i < vertices; i++) {
			List<Node> list = new ArrayList<>();
			graph.put(i, list);
		}
	}

	void findDjikstra(int source) {
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
					
					minHeap.remove(neighbour);
					distance[neighbour.vertex] = distance[n.vertex] + neighbour.weight;

					Node temp = new Node(neighbour.vertex, distance[neighbour.vertex]);
					minHeap.add(temp);
					System.out.print("\tUpdating : "+neighbour.vertex+" new distance : "+distance[neighbour.vertex]);
					// if(distance[neighbour.vertex] < min_dist) {
					// min_dist = distance[neighbour.vertex];
					// min = neighbour;
					// }
				}

			}
			System.out.println("\nMinHeap : " + minHeap);

		}

		for (int i = 0; i < vertices; i++) {
			System.out.print(i + " " + distance[i] + "\t");
		}
	}

	void addEdge(int source, int dest, int weight) {
		Node n = new Node(dest, weight);
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
		Djikstra ob = new Djikstra(5);
		ob.addEdge(0, 1, 5);
		ob.addEdge(0, 2, 15);
		ob.addEdge(1, 2, 6);
		ob.addEdge(2, 3, 2);
		System.out.println(ob.graph);
		ob.findDjikstra(0);

	}
}