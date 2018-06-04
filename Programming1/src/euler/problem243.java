package euler;
import java.util.HashSet;
import java.util.Set;

public class problem243 {
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		while (b != 0) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	public static void main(String args[]) {
		float L = 15499 / (float) 94744.0;
		long t1 = System.currentTimeMillis();
		for (int d = 170000; ; d++) {
			float count = 0;
			Set<Integer> list = new HashSet<Integer>();
			for (int i = 2; i <= d - 2; i++) {
				if (list.contains(i))
					continue;
				if (gcd(i, d) != 1) {
					// put in multiples of i here
					for (int j = i; j < d; j = j + i)
						list.add(j);
				}
			}
			count = d - 1 - list.size();
			float rd = (count) / (d - 1);
			System.out.println(d + "  " + count + "  " + rd + "  " + L);
			if (rd < L) {
				System.out.println(d);
				break;
			}

		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}