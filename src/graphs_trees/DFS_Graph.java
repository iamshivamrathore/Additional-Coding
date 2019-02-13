package graphs_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DFS_Graph {

	Map<Integer, List<Integer>> map;

	DFS_Graph(int n) {
		map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

	}

	void addEdge(int source, int dest) {
		// map.get(dest).add(source);
		map.get(source).add(dest);

	}

	void display() {
		System.out.println(map);
	}

	void DFS(int source) {
		List<Integer> solution = new ArrayList<>();
		int n = map.size();
		boolean[] visited = new boolean[n];
		// Stack<Integer> queue = new Stack<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {
			int node = queue.remove();
			// if (visited[node]) {
			// continue;
			// }
			visited[node] = true;
			solution.add(node);
			System.out.println("\n\nPopped Node : " + node);
			List<Integer> neighbours = map.get(node);
			Iterator<Integer> it = neighbours.iterator();
			System.out.println("Neighbours : " + neighbours);
			while (it.hasNext()) {
				int neighbour = it.next();
				System.out.println("Neighbour " + neighbour);
				if (!visited[neighbour]) {
					 visited[neighbour] = true;
					queue.add(neighbour);
					System.out.println("---");
				}
			}

			System.out.println("Stack : " + queue);
		}

		System.out.println("DFS : " + solution);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DFS_Graph g = new DFS_Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);

		g.addEdge(1, 5);
		g.addEdge(1, 6);
		g.addEdge(6, 4);

		g.addEdge(4, 1);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 2);
		g.display();
		g.DFS(0);
	}

}

// 0 1 5 6 4 2 3
