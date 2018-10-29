/*Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
method to find the location of a given string.
EXAMPLE
Input: ball, {((at",
((JJ}
Output: 4*/

package sort_search;

public class SparseSearch {

	static int binSearch(String arr[], int l, int h, String str) {
		int med = (l + h) / 2;

		if (l <= h) {
			if (arr[med].equals("")) {
				int i = med - 1, j = med + 1;
				for (; i >= l && j <= h; i--, j++) {

					if (!arr[i].equalsIgnoreCase("")) {

						med = i;
						break;
					}
					if (!arr[j].equals("")) {
						med = j;
						break;
					}
				}
				while (i >= l) {
					if (!arr[i].equalsIgnoreCase("")) {
						med = i;
						break;
					}
					i--;
				}
				while (j <= h) {
					if (!arr[j].equals("")) {
						med = j;
						break;
					}
					j++;
				}
				

			}

			int comp = str.compareToIgnoreCase(arr[med]);
			if (comp == 0) {
				return med;
			} else if (comp > 0) {
				return binSearch(arr, med + 1, h, str);
			} else {
				return binSearch(arr, l, med - 1, str);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str[] = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		String search = "das";

		System.out.println(binSearch(str, 0, str.length - 1, search));
	}

}
