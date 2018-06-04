package hackerank;

/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
 */

import java.util.Scanner;

public class Fibonacci {
	public final static boolean isPerfectSquare(long n) {
		if (n < 0)
			return false;

		long tst = (long) (Math.sqrt(n) + 0.5);
		return tst * tst == n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T > 0) {
			T--;
			int K = in.nextInt();
			if (K % 2 == 0) {
				System.out.println(2 + " " + 2);
				continue;
			}
			if (K == 3) {
				System.out.println(3 + " " + 3);
				continue;
			}
			int a = 2, b = 3;
			for (;;) {
				int F = a + b;
				boolean flag=false;
				for (int D = 3; D <= F ; D = D + 2) {
					if (F % D == 0) {
						if (K % D == 0) {
							System.out.println(F + " " + D);
							flag=true;
							break;
						}
					}
				}
				if(flag)
					break;
				a = b;
				b = F;
			}
		}
	}
}
/*
 * public static void main(String[] args) { Scanner in = new Scanner(System.in);
 * int t = in.nextInt(); while (t > 0) { t--; int K = in.nextInt(); if (K % 2 ==
 * 0) { System.out.println(2 + " " + 2); continue; } if (K == 3) {
 * System.out.println(3 + " " + 3); continue; }
 * 
 * for (int D = 3; D <= K; D = D + 2) { if (K % D == 0) { int pos = 1; int mul =
 * 1; boolean flag = false; while (true) { mul = D * pos; int square1 = 5 * mul
 * * mul - 4; int square2 = 5 * mul * mul + 4; if (isPerfectSquare(square1) ||
 * isPerfectSquare(square2)) { flag = true; break; } pos++; } if (flag) {
 * System.out.println(mul + " " + D); break; } } } } }
 */

