package sort_search;

public class MergeSort {

	// static int arr[] = { 2, 1, 3, 1, 2 };
	static int count = 0;

	static void divide(int arr[], int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;

			divide(arr, left, middle);
			divide(arr, middle + 1, right);

			merge(arr, left, middle, right);
		}
	}

	private static void merge(int arr[], int left, int middle, int right) {

		int n1 = middle - left + 1;
		int n2 = right - middle;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[left + i];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = arr[middle + 1 + i];
		}
		System.out.println("Left : " + left + "Middle : " + middle + " Right: " + right);
		System.out.print("Left : ");
		display(L);
		System.out.print("Right : ");
		display(R);
		System.out.println("Before : ");
		// display(left, right);
		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
		//	arr[k++] = (L[i] < R[j]) ? L[i++] : R[j++];

			if (L[i] <= R[j]) {
				System.out.print("--x--");
				arr[k++] = L[i++];

			} else {
				System.out.print("--y--");

				count += n1 - i;

				arr[k++] = R[j++];

			}
		}
		System.out.println();
		while (i < n1) {
			arr[k++] = L[i++];
		}
		while (j < n2) {
			arr[k++] = R[j++];
		}
		System.out.println("************Count : " + count);
		System.out.println("After");
		// display(left, right);
		System.out.println("\n");

	}

	static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 7, 5, 3, 1 };
		divide(arr, 0, arr.length - 1);
		// display();
		System.out.println("Count : " + count);
	}

}
