package graphs_trees;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KruskalMST {

	int vertices;

	static class Edge {
		int source;
		int dest;
		int weight;

		Edge(int a, int b, int c) {
			source = a;
			dest = b;
			weight = c;
		}

		@Override
		public String toString() {
			return "[" + source + "," + dest + " (" + weight + ")] ";
		}

	}

	List<Edge> edges;

	KruskalMST(int n) {
		edges = new LinkedList<>();
		vertices = n;
	}

	void addEdge(int source, int dest, int weight) {
		Edge e = new Edge(source, dest, weight);
	//	Edge e2 = new Edge(dest, source, weight);
		edges.add(e);
	//	edges.add(e2);
	}

	void Kruskal() {
		edges.sort(new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {
				if (e2.weight < e1.weight) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		List<Edge> MST = new LinkedList<>();
		Iterator<Edge> it = edges.iterator();
		int parent[] = new int[vertices];
		for(int i=0;i<vertices;i++) {
			parent[i] = -1;
		}
		while (MST.size() != edges.size() - 1 && it.hasNext()) {
			Edge e = it.next();
			System.out.println(e);
			if(findParent(parent, e.dest) != findParent(parent, e.source)) {
				Union(parent, e.dest, e.source);
				MST.add(e);
			}
		}
		System.out.println(edges);
		System.out.println(MST);
	}

	int findParent(int arr[], int i) {
		System.out.println("In Find Parent for : "+i);
		if (arr[i] == -1) {
			System.out.println("Return :"+i);
			return i;
		} else {
			
			return findParent(arr, arr[i]);
		}
	}

	void Union(int parent[], int x, int y) {
		int xPar = findParent(parent, x);
		int yPar = findParent(parent, y);
		parent[xPar] = yPar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KruskalMST g = new KruskalMST(9);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);

		g.Kruskal();
	}

}
