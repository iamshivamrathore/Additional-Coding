package graphTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

	Map<Integer, List<Integer>> graph;

	Graph() {
		graph = new HashMap<>();
	}

	void addDirectedEdge(int src, int dest) {
		if (graph.containsKey(src)) {

			graph.get(src).add(dest);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(dest);
			graph.put(src, list);
		}
	}

	void addUndirectedEdge(int src, int dest) {
		if (graph.containsKey(src)) {
			graph.get(src).add(dest);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(dest);
			graph.put(src, list);
		}
		if (graph.containsKey(dest)) {
			graph.get(dest).add(src);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(src);
			graph.put(dest, list);
		}

	}

	public String toString() {
		return graph.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(1, 6);
		g.addUndirectedEdge(1, 8);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(5, 4);
		g.addUndirectedEdge(3, 8);
		g.addUndirectedEdge(5, 4);
		g.addUndirectedEdge(5, 9);
		g.addUndirectedEdge(9, 3);
		g.addUndirectedEdge(9, 7);
		g.addUndirectedEdge(6, 7);
		System.out.println(g);
		
		g.BFS(1);
	}

	 void BFS(int source) {
		
		boolean visited[] = new boolean[graph.size()+1];

		Queue<Integer> queue = new LinkedList<>();
		// Set<Integer> vertices = new HashSet<>();
		visited[source] = true;
		queue.add(source);
		while (!queue.isEmpty()) {
			
			int num = queue.remove();
			System.out.print(num+"\t");
			List <Integer> list = graph.get(num);
			for(int i=0;i<list.size();i++) {
				int vertex = list.get(i);
				if(!visited[vertex]) {
					queue.add(vertex);
					visited[vertex] = true;
				}
			}
		}

	}

}
