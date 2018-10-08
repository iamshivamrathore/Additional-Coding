/*String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").*/


package arrays_strings;

import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		s.close();
		isRotation(s1, s2);

	}

	private static void isRotation(String s1, String s2) {
		// TODO Auto-generated method stub
		int firstIndex = -1;

		for (int i = 0; i < s2.length(); i++) {
			if (s1.charAt(0) == s2.charAt(i)) {
				System.out.println("Found at : "+i);
				firstIndex = i;
				break;
			}

		}

		System.out.println(s2.substring(firstIndex, s2.length()));
		
		System.out.println(s2.substring(0, s2.length() - 1 - firstIndex - 1));
		String s = s2.substring(firstIndex, s2.length()) + s2.substring(0, s2.length() - 1 - firstIndex - 1);
		System.out.println(s);
		
	}

}
