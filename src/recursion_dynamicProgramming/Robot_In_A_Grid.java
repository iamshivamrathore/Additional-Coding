package recursion_dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class Robot_In_A_Grid {

	static boolean calc(List<Coordinate> list, Set<Coordinate> failed, int arr[][], int r, int c) {

		if (r < 0 || c < 0 || arr[r][c] == 0) {
			return false;
		}

		if (failed.contains(new Coordinate(r, c))) {
			System.out.println(" 123xyz");
			return false;
		}
		Coordinate node = new Coordinate(r, c);
		if ((r == 0 && c == 0) || calc(list, failed, arr, r - 1, c) || calc(list, failed, arr, r, c - 1)) {

			list.add(node);
			return true;
		}

		failed.add(node);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = { { 1, 0, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
		List<Coordinate> list = new ArrayList<>();
		Set<Coordinate> failed = new HashSet<>();
		calc(list, failed, arr, 3, 3);
		System.out.println("--------:" + list);
	}

}
