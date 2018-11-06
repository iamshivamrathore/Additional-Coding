/*Peaks and Valleys: In an array of integers, a "peak" is an element which is greater than or equal to
the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers.
For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys. Given an array
of integers, sort the array into an alternating sequence of peaks and valleys.
EXAMPLE
Input: {5, 3, 1,2, 3}
Output: {5, 1,3,2, 3}*/

package sort_search;

public class PeaksAndValleys {

	static void arrange(int arr[]) {
		for (int i = 1; i < arr.length - 1; i += 2) {
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
				// Do nothing, middle one already largest
			} else {
				swap(arr, i, (arr[i + 1] > arr[i - 1] ? (i + 1) : (i - 1)));
			}
		}
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 10, 3, 8, 2,  1};
		arrange(arr);
		display(arr);
	}

}
