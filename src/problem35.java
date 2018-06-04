import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class problem35 {
	static Set<Long> primes = new HashSet<Long>();
	static Set<Long> newprimes = new HashSet<Long>();

	static boolean isPrime(long n) {
		if (n == 1)
			return false;
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	public static int rotateandSolve(long n) {
		StringBuffer x = new StringBuffer(n + "");
		Set<Long> localprimes = new HashSet<Long>();
		int count = 0;
		for (int i = 1; i < x.length(); i++) {
			char first = x.charAt(0);
			x = x.deleteCharAt(0);
			x = x.append(first);
			long num = new Long(x.toString());
			localprimes.add(num);
			if (num == n)
				count++;
			if (!primes.contains(num)) {
				return 0;
			}
		}
		newprimes.addAll(localprimes);
		newprimes.add(n);
		return localprimes.size() + 1 - count;
	}
	
	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		primes.add((long) 2);
		for (int i = 3; i < 10000000; i = i + 2) {
			if (isPrime(i))
				primes.add((long) i);
		}
		long sum = 0;
		Iterator<Long> it = primes.iterator();

		while (it.hasNext()) {
			long num = it.next();
			if (!newprimes.contains(num))
				sum += rotateandSolve(num);
		}
		System.out.println(sum);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
