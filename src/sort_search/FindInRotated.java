/*Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
number of times, write code to find an element in the array. You may assume that the array was
originally sorted in increasing order.
EXAMPLE
Input:findSin{lS, 16, 19, 2a, 25, 1, 3,4,5,7, la, 14}
Output: 8 (the index of 5 in the array)
*/
package sort_search;

public class FindInRotated {

	static int enhancedBinary(int arr[], int low, int high, int num) {
	//	System.out.println("Low : "+low);
		int med = (low + high) / 2;
		if (num == arr[med]) {
			return med;
		}

		
		else if (arr[med] < arr[high]) {
			if (num > arr[med] && num < arr[high]) {
				System.out.println("1");
				return enhancedBinary(arr, med + 1, high, num);
			} else {
				System.out.println("2");
				return enhancedBinary(arr, low, med -1, num);
			}
		} else {
			if (num < arr[med] && num > arr[low]) {
				System.out.println("3");
				return enhancedBinary(arr, low, med - 1, num);
			} else {
				System.out.println("4");
				return enhancedBinary(arr, med + 1, high, num);
			}
		}
	}

	public static void main(String[] args) {

		int arr1[] = { 5, 1, 2, 3, 4 };

		int arr2[] = { 2, 3, 4, 5, 1 };
		
//		System.out.println("------------------"+enhancedBinary(arr1, 0, 4, 1));
//		System.out.println("------------------"+enhancedBinary(arr1, 0, 4, 3));
//		System.out.println("------------------"+enhancedBinary(arr2, 0, 4, 5));
		System.out.println("------------------"+enhancedBinary(arr2, 0, 4, 3));

	}

}
