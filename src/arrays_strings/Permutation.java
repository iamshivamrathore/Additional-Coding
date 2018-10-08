//Given two strings, write a method to decide if one is a permutation of the other.
package arrays_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String string1 = s.next();
		String string2 = s.next();
		s.close();
		System.out.println(isPermutation(string1, string2));
	}

	private static boolean isPermutation(String str1, String str2) {
		// TODO Auto-generated method stub
		Map<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if (frequency.containsKey(ch)) {
				frequency.put(ch, frequency.get(ch) + 1);
			} else {
				frequency.put(ch, 1);
			}
		}
		System.out.println(frequency + "\n");

		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if (frequency.get(ch) < 1) {
				return false;
			} else {
				frequency.put(ch, frequency.get(ch) - 1);
			}
			System.out.println(frequency);
		}
		return true;
	}

}
