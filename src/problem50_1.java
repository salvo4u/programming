import java.util.ArrayList;

public class problem50_1 {

	static boolean isPrime(long n) {
		if (n == 1)
			return false;
		for (int j = 2; j * j <= n; j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		int N = 1000000;
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(2);

		long t1 = System.currentTimeMillis();
		for (int i = 3; i <= N; i = i + 2) {
			if (isPrime(i))
				p.add(i);
		}
		// System.out.println(p);
		long max = 0;
		long myprime = 0;
		for (int k = 0; k < p.size(); k++) {
			int prime = p.get(k);
			for (int length = 1; length <= p.size(); length++) {
				for (int start = 0; start < p.size() - length; start++) {
					int end = start + length;
					long sum = 0;
					for (int j = start; j <= end; j++)
						sum = sum + p.get(j);
					if (sum > prime)
						break;
					if (sum == prime) {
						if (length > max) {
							myprime = sum;
							max = length;
						}
					}
				}
			}
		}
		System.out.println(myprime);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
