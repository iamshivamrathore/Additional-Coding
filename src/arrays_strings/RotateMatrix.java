//Rotate a 2d matrix by 90 degrees, in place
package arrays_strings;

public class RotateMatrix {

	public static void display(int arr[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		display(arr, 4);
		int n = 4;
		for (int i = 0; i < n / 2; i++) {
			rotate1(arr, i,n -1);
			display(arr, 4);
		}

		
	}

	private static void rotate1(int[][] arr, int i, int n) {
		
		//	System.out.println("Element : "+arr[i][i]);
			int temp = arr[i][i];
			arr[i][i] = arr[n - i][i];
			arr[n - i][i] = arr[n - i][n - i];
			arr[n - i][n - i] = arr[i][n - i];
			arr[i][n - i] = temp;display(arr, 4);

		//	display(arr, 4);

		

	}

}
