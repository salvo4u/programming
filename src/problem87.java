import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class problem87 {
	static boolean isPrime(long n) {
		if (n == 1)
			return false;
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<Long> primes4 = new ArrayList<Long>();
		List<Long> primes3 = new ArrayList<Long>();
		List<Long> primes2 = new ArrayList<Long>();
		int N = 50000000;
		long i = 2;
		primes2.add(i);
		primes3.add(i);
		primes4.add(i);
		
		long t1 = System.currentTimeMillis();
		for (i = 3; i <= 7072; i = i + 2) {
			if (isPrime(i)) {
				primes2.add(i);
				if (i < 369)
					primes3.add(i);
				if (i < 85)
					primes4.add(i);

			}
		}

		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		for (Iterator<Long> iterator = primes4.iterator(); iterator.hasNext();) {
			Long i1 = (Long) iterator.next();
			for (Iterator<Long> iterator2 = primes3.iterator(); iterator2
					.hasNext();) {
				Long i2 = (Long) iterator2.next();
				long number1 = i1 * i1 * i1 * i1 + i2 * i2 * i2;

				if (number1 > N)
					break;
				for (Iterator<Long> iterator3 = primes2.iterator(); iterator3
						.hasNext();) {
					Long i3 = (Long) iterator3.next();
					long number2 = number1 + i3 * i3;
					if (number2 < N && map.get(number2 + "") == null)
						map.put(number2 + "", true);

					if (number2 > N)
						break;

				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(map.keySet().size());
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}