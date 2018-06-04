import java.util.ArrayList;
import java.util.Iterator;

public class problem50 {
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
		int N = 1000;
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(2);
		long t1 = System.currentTimeMillis();
		for (int i = 3; i <= N; i = i + 2) {
			if (isPrime(i))
				p.add(i);
		}

		int pos = 0;
		long max = 0, myprime = 0;

		for (pos = 0; pos < p.size(); pos++) {
			long prime = p.get(pos);
			long sum = 0;
			for (int i = 0; i < pos; i++) {
				sum = 0;
				for (int j = 0; j < i; j++)
					sum = sum + p.get(j);
				if(prime==953)
					System.out.println(sum+">>"+953);
				if (sum > prime)
					break;
				if (sum == prime) {
					System.out.println(sum + " ---> " + i);
					if (i >= max) {
						max = i;
						myprime = prime;
					}
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(max + " -----> " + myprime);
		System.out.println(p);
		System.out.println(p.contains(958577));
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
