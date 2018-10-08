package arrays_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		System.out.println(compress(str));
	}

	private static String compress(String str) {
		// TODO Auto-generated method stub
		class StrObject {
			char ch;
			int count;

			StrObject(char ch, int count) {
				this.ch = ch;
				this.count = count;
			}
		}

		List<StrObject> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int count = 0;
			StrObject obj = new StrObject(ch, count);
			while (i < str.length() && ch == str.charAt(i)) {
				i++;
				count++;
			}
			i--;
			obj.count = count;
			list.add(obj);
			
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).ch + "" + list.get(i).count);
		}
	//	System.out.println("SB : " + sb.toString());
		if (sb.length() < str.length()) {
			return sb.toString();
		} else {
			return str;
		}

	}

}
