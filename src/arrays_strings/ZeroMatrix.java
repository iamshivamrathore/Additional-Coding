/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to O.*/

package arrays_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZeroMatrix {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 0, 0, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 },{17,18,19,20} };
		int M = 5;
		int N = 4;
		display(arr, M, N);
		zero(arr, M, N);
		
		display(arr, M, N);
	}

	static void display(int arr[][], int M, int N) {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+"\t");
			}System.out.println();
		}
		System.out.println();
	}
	static void zero(int arr[][], int M, int N) {
		class Element {
			int x, y;

			Element(int x, int y) {
				this.x = x;
				this.y = y;
			}
			public String toString() {
				return "("+x+","+y+")";
			}
		}
		
		List<Element> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 0) {
					Element e = new Element(i, j);
					list.add(e);
				}
			}
		}
		System.out.println(list);
		Set<Integer> rowDeleted = new HashSet<>();
		Set<Integer> colDeleted = new HashSet<>();
		for(int i=0;i<list.size();i++) {
			delete(arr, list.get(i).x, list.get(i).y, M,N,rowDeleted, colDeleted);
		}

	}

	private static void delete(int[][] arr, int x, int y, int M, int N, Set<Integer> rowDeleted, Set<Integer> colDeleted) {
		System.out.println("Deleting : "+"("+x+","+y+")");
		if(!rowDeleted.contains(x)) {
	//		System.out.println("Not contains x");
			rowDeleted.add(x);
			for(int i=0;i<N;i++) {
		//		System.out.print("Deleting : "+arr[i][y]);
				arr[x][i] = 0;
			}
		}
		if(!colDeleted.contains(y)) {
	//		System.out.println("Not contains y");
			colDeleted.add(y);
			for(int i=0;i<M;i++) {
				arr[i][y] = 0;
			}
		}
	}
}