package graphs_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;

public class BuildOrder {

	static class Graph {
		private Map<Character, List<Character>> map;
		int n;
		List<Character> inIndex;
		private Map<Character, Boolean> visited;
		List<Character> alone;

		Graph() {
			map = new HashMap<>();
			inIndex = new ArrayList<>();
			alone = new ArrayList<>();
			n = 0;
		}

		void addEdge(Character src, Character dest) {

			map.get(src).add(dest);
			inIndex.remove(dest);

		}

		
		void calcN() {
			Iterator<Character> it = map.keySet().iterator();
			while (it.hasNext()) {
				char ch = it.next();
				if (map.get(ch).size() == 0 && inIndex.contains(ch)) {
					System.out.println("N + for : " + ch);
					alone.add(ch);
				}
			}

		}

		public String toString() {
			return map.toString();
		}

		List<Character> BST() {
			calcN();

			List<Character> list = null;
			System.out.println("Independent : " + inIndex);
			Iterator<Character> it = inIndex.iterator();
			while (it.hasNext()) {
				visited = new HashMap<>();

				Iterator<Character> it1 = map.keySet().iterator();
				while (it1.hasNext()) {
					visited.put(it1.next(), false);
				}

				list = new ArrayList<>();

				Queue<Character> queue = new LinkedList<>();
				char key = it.next();

				visited.put(key, true);
				queue.add(key);
				while (!queue.isEmpty()) {
					char ch = queue.poll();
					list.add(ch);
					List<Character> neighbours = map.get(ch);

					for (int i = 0; i < neighbours.size(); i++) {
						char neighbour = neighbours.get(i);
						if (visited.get(neighbour) == false) {
							queue.add(neighbour);
							visited.put(neighbour, true);
						}
					}
				}

				System.out.println("BFS : " + list);
				System.out.println(n);
				if (list.size() + alone.size() == map.size()) {
					List<Character> newList = new ArrayList<>();
					Stream.of(list, alone).forEach(newList::addAll);
					return newList;
				}

			}
			return null;
		}

		// private List<Character> getIndependentNodes() {
		// List<Character> list = new LinkedList<>();
		// Iterator<Character> iterator = map.keySet().iterator();
		// while (iterator.hasNext()) {
		// char key = iterator.next();
		// if (map.get(key).size() == 0) {
		// list.add(key);
		// }
		// }
		// return list;
		// }

		public void createGraph(String vertices) {
			// TODO Auto-generated method stub

			vertices = vertices.replaceAll(" ", "");
			String[] verticesArray = vertices.split(",");
			for (int i = 0; i < verticesArray.length; i++) {
				char ch = verticesArray[i].charAt(0);
				map.put(ch, new ArrayList<Character>());
				inIndex.add(ch);

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		// System.out.println("Enter projects");
		// String projects = s.nextLine();
		//
		String projects = "a, b, c, d, e, f";

		projects = projects.replaceAll(" ", "");
		System.out.println("Enter dependencies");
		String dependencies = s.nextLine();
		s.close();

		dependencies = dependencies.replaceAll("\\(", "");
		dependencies = dependencies.replaceAll("\\)", "");
		dependencies = dependencies.replaceAll(" ", "");
		Graph g = new Graph();

		g.createGraph(projects);

		String dep[] = dependencies.split(",");
		for (int i = 0; i < dep.length - 1; i = i + 2) {

			g.addEdge(dep[i].charAt(0), dep[i + 1].charAt(0));

		}

		System.out.println(g);
		System.out.println(g.n);
		System.out.println("Answer : " + g.BST());

	}

}
