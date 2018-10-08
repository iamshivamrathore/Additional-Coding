/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, pIe -> true
pales. pale -> true
pale. bale -> true
pale. bake -> false*/

package arrays_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		
		s.close();
		System.out.println(isOneAway(str1, str2));
	}

	private static boolean isOneAway(String str1, String str2) {

		boolean result;
		if (str1.length() > str2.length()) {
			result = isOneAwayImplement(str1, str2);
		} else {
			result = isOneAwayImplement(str2, str1);
		}
		return result;
	}

	private static boolean isOneAwayImplement(String biggerString, String smallerString) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < biggerString.length(); i++) {
			char ch = biggerString.charAt(i);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (int i = 0; i < smallerString.length(); i++) {
			char ch = smallerString.charAt(i);
			if(map.containsKey(ch)) {
				int freq = map.get(ch);
				if(freq>1) {
					freq --;
					map.put(ch, freq);
				}else {
					map.remove(ch);
				}
			}else {
				return false;
			}
		}
		return true;
	}

}
