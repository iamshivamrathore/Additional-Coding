package recursion_dynamicProgramming;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;

public class Steps {

	static int countWays(int n, int arr[]) {
		arr[0] = arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		if (arr[n] == 0) {
			arr[n] = countWays(n - 3, arr) + countWays(n - 2, arr) + countWays(n - 1, arr);
		}
		return arr[n];
	}

	static int countSteps(int n) {
//		System.out.println("N: " + n);
		if (n == 1 || n == 0) {
	//		System.out.println("1");
			return 1;
		}
		if (n == 2) {
	//		System.out.println("2");
			return 2;
		}
		if (n == 3) {
	//		System.out.println("3");
			return 4;
		}

		return (countSteps(n - 3) + countSteps(n - 2) + countSteps(n - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String str;
		
		int num = 7;
		LocalDateTime t1 = LocalDateTime.now();
		System.out.println(countSteps(num));
		LocalDateTime t2 = LocalDateTime.now();
		Duration duration = Duration.between(t1, t2);

		System.out.println("Duration : " + duration);
		System.out.println("------------------");

		t1 = LocalDateTime.now();

		System.out.println(countWays(num, new int[num + 1]));
		t2 = LocalDateTime.now();
		duration = Duration.between(t1, t2);

		System.out.println("Duration : " + duration);
	}

}
