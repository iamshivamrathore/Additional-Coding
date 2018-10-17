package graphs_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {

	int inDegree[];

	static class Node {
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

	Map<Integer, List<Node>> map;

	void addEdge(int source, int dest, int weight) {
		Node n = new Node(dest, weight);
		List<Node> list = map.get(source);
		list.add(n);
		inDegree[dest]++;
		System.out.println(map);
	}

	void addEdge(int source, int dest) {
		Node n = new Node(dest, 0);
		List<Node> list = map.get(source);
		list.add(n);
		inDegree[dest]++;
		System.out.println(map);
	}

	TopologicalSort(int vertices) {
		map = new HashMap<>();
		List<Node> list;
		inDegree = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			list = new ArrayList<>();
			map.put(i, list);
		}
	}

	
	void actualSorting() {
		Queue<Integer> queue = new PriorityQueue<>();
		boolean visited[] = new boolean[inDegree.length];
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}
		List<Integer> answer = new ArrayList<>();
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			visited[vertex] = true;
			answer.add(vertex);
			List<Node> neighbours = map.get(vertex);
			System.out.println("For : "+vertex +" Neighbours are : "+neighbours);
			for(int i=0;i<neighbours.size();i++) {
				int neighbour = neighbours.get(i).vertex;
				inDegree[neighbour]--;
				if(inDegree[neighbour] == 0 &!visited[neighbour]) {
					queue.add(neighbour);	
				}
			}
		}
		System.out.println("Answer : "+answer);
	}
	void displayInDegree() {
		for (int i = 0; i < inDegree.length; i++) {
			System.out.print(i + ": " + inDegree[i] + "\t");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.actualSorting();
		//g.displayInDegree();

	}

}
