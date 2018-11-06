/*Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
ascending order, write a method to find an element.*/
package sort_search;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 11, 12, 13 }, { 10, 14, 15, 16 }, { 17, 18, 19, 20 } };
		display(arr, 5, 4);

		findPos(arr, 5, 4, 15);
	}

	private static void findPos(int[][] arr, int M, int N, int num) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		boolean found = false;
		while (i < M && j < N) {
			// System.out.println(i + " , " + j);
			if (arr[i][j] == num) {
				System.out.println(num + " found at pos : (" + i + "," + j + ")");
				break;
			}

			if (num > arr[i][N - 1]) {
				i++;

			}
			if (num > arr[M - 1][j]) {
				j++;
			}
			if (num < arr[i][N - 1] && num < arr[M - 1][j]) {
				while (i < M) {
					int pos = binSearch(arr[i], i, N - 1, num);
					if (pos != -1) {
						System.out.println("Pos : (" + i + "," + pos + ")");
						found = true;
						break;
					}
					i++;
				}

				break;

			}
		}

		if (!found) {
			System.out.println("Not found");
		}

	}

	static void display1(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int binSearch(int[] arr, int l, int h, int num) {
	//	display1(arr);

		int m = (l + h) / 2;
		// System.out.println("----" + arr[m]);
		// System.out.println("Num " + num);
		if (num == arr[m]) {
			return m;
		}
		if (l <= h) {

			if (num > arr[m]) {
				// System.out.println("----1");
				return binSearch(arr, m + 1, h, num);
			} else {
				// System.out.println("----2");
				return binSearch(arr, l, m - 1, num);
			}
		}
		return -1;

	}

	static void display(int arr[][], int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
