/*Write a method to replace all spaces in a string with '%20: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith "J 13
Output: "Mr%20John%20Smith"
*/
package arrays_strings;

public class URLify {

	public static void main(String[] args) {

		String str = "Mr John Smith          ";
		char arr[] = str.toCharArray();
		// System.out.println(arr.length);
		System.out.println(urlify(arr, 13));
	}

	static void display(char[] arr) {
		String str = new String(arr);
		System.out.println(str);
	}

	private static char[] urlify(char[] arr, int len) {
		// TODO Auto-generated method stub

		int arrLength = len;
		// System.out.println("Arr Len : "+);
		for (int i = 0; i < len; i++) {
			if (arr[i] == ' ') {
		//		System.out.println(i);
				for (int j = arrLength + 2; j >= i + 2; j--) {
					arr[j] = arr[j - 2];
		//			display(arr);
				}
				arr[i] = '%';
				arr[++i] = '2';
				arr[++i] = '0';
				len += 2;
				arrLength += 2;
			}
			// display(arr);
		}
		return arr;
	}
}
