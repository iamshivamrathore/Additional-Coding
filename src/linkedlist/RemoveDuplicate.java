package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String string = s.next();
		s.close();
		List <Character> list = new ArrayList<>();
		for(int i=0;i<string.length();i++) {
			list.add(string.charAt(i));
		}
	//	string.chars().forEach(i -> list.add((char)i));
		list = new ArrayList<>(new LinkedHashSet<>(list));
		Collections.reverse(list);
		System.out.println(list);
	}

	

}
