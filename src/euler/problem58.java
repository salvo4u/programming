package euler;
import java.util.TreeMap;
public class problem58 {
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		int tn = 3, n = 3;
		TreeMap<Integer, String> tp = new TreeMap<Integer, String>();
		tp.put(3, 3 + " " + .75);
		long t1 = System.currentTimeMillis();
		while (true) {
			int count = 0;
			int add = ((n + 2) / 2) * 2;

			int ele1 = (n * n + 1 + n);
			int ele2 = ele1 + add;
			int ele3 = ele2 + add;

			if (isPrime(ele1)) {
				count++;
			}

			if (isPrime(ele2)) {
				count++;
			}

			if (isPrime(ele3)) {
				count++;
			}

			n = n + 2;
			tn = tn + count;
			double frac = ((double) tn) / (2 * n - 1);

			tp.put(n, tn + "  " + frac);

			if (frac < .1) {
				System.out.println(n);
				break;
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME:" + (t2 - t1) + "millisec");
	}
}
