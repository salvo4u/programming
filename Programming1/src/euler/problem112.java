package euler;
import java.util.ArrayList;

public class problem112 {
	public static void main(String args[]) {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		long t1 = System.currentTimeMillis();

		int N = 1586886;

		for (int i = 100; i <= N; i++) {
			String number = i + "";
			int k = -1;
			while (true) {
				k++;
				if (k == number.length() - 1)
					break;

				if (number.charAt(k) == number.charAt(k + 1))
					continue;

				if (number.charAt(k) > number.charAt(k + 1)) {
					int flag = 0;
					for (int j = 1; j < number.length() - 1; j++) {
						if (number.charAt(j) < number.charAt(j + 1)) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						// number is bouncy
						alist.add(i);
						break;
					}
				} else if (number.charAt(k) <= number.charAt(k + 1)) {
					int flag = 0;
					for (int j = 1; j < number.length() - 1; j++) {
						if (number.charAt(j) > number.charAt(j + 1)) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						// number is bouncy
						alist.add(i);
						break;
					}
				}
			}
		}

		while (true) {
			N++;
			String number = N + "";
			int k = -1;
			while (true) {
				k++;
				if (k == number.length() - 1)
					break;

				if (number.charAt(k) == number.charAt(k + 1))
					continue;

				if (number.charAt(k) > number.charAt(k + 1)) {
					int flag = 0;
					for (int j = 1; j < number.length() - 1; j++) {
						if (number.charAt(j) < number.charAt(j + 1)) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						// number is bouncy
						alist.add(N);
						break;
					}
				} else if (number.charAt(k) <= number.charAt(k + 1)) {
					int flag = 0;
					for (int j = 1; j < number.length() - 1; j++) {
						if (number.charAt(j) > number.charAt(j + 1)) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						// number is bouncy
						alist.add(N);
						break;
					}
				}

			}
			double exp=(double)alist.size()/N*100;
			if (exp == 99)
				break;
		}
	System.out.println(N);
	long t2 = System.currentTimeMillis();
	System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
