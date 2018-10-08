//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

package arrays_strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		String str = s.next();
		s.close();
		System.out.println(isUnique(str));
		System.out.println(isUniqueWithoutAdditional(str));
	}

	private static boolean isUnique(String word) {

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (set.contains(ch)) {
				return false;
			} else {
				set.add(ch);
			}
		}
		return true;
	}

	private static boolean isUniqueWithoutAdditional(String word) {

		int arr[] = new int[26];
		word = word.toUpperCase();
		for (int i = 0; i < word.length(); i++) {
			
			if(arr[word.charAt(i)-65]>=1) {
				return false;
			}else {
				arr[word.charAt(i)-65]++;
			}
		}
		return true;
	}

}
