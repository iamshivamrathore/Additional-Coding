package sort_search;

public class MergeSorted {

	static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = { 1, 4, 8, 10, 12, 15, 0, 0, 0, 0 };
		int n1 = A.length;
		int B[] = { 2, 5, 7, 11 };
		int n2 = B.length;
		System.out.println("n1 : " + n1);
		int count = 0;
		int shift[] = new int[n1 - n2];
		int insert[] = new int[n2];
		int i = 0;
		for (int j = 0; i < shift.length && j < n2;) {

			if (A[i] <= B[j]) {
				shift[i] = count;
				i++;
			} else {
				insert[j] = i + count;
				count++;
				j++;
			}

		}
		while (i < (n1 - n2)) {
			shift[i++] = count;
		}

		display(shift);
		display(insert);

		for (i = shift.length - 1; i >= 0; i--) {
			// System.out.print(i + " ");
			A[i + shift[i]] = A[i];
			display(A);

			System.out.println();
		}
		for (i = 0; i < B.length; i++) {
			A[insert[i]] = B[i];
			display(A);
		}
		System.out.println("Ans : ");

	}

}
