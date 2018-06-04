import java.util.Vector;

public class problem70 {
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	static Vector<String> primes = new Vector<String>();

	public static double breakNumber(int n) {
		System.out.println(n);
		int i = 0;
		double ret = 0;
		while (n != 1) {
			int p = new Integer(primes.get(i++).toString()), pwer = 0;
			while (n % p == 0) {
				pwer++;
				n = n / p;
			}
			ret = ret + Math.pow(p, pwer - 1) * (p - 1);
		}
		return ret;
	}

	public static double phiFunc(int n) {
		int i = 0;
		double ret = 1;
		int p = new Integer(primes.get(i++).toString());
		while (i < primes.size()) {
			if (n % p == 0) {
				ret = ret * (1 - (float) 1 / p);
			}
			p = new Integer(primes.get(i++).toString());
		}
		return ret * n;
	}

	public static void main(String args[]) {
		float min = 10000, frac = 0;
		int n = 10000, myn = 10;
		long t1 = System.currentTimeMillis();
		for (int i = 2; i <= n; i++) {
			// System.out.println(i);
			if (isPrime(i)) {
				primes.add(i + "");
				frac = (float) i / (i - 1);
			} else
				frac = (float) (i / phiFunc(i));
			
			if (frac < min) {
				min = frac;
				myn = i;
				System.out.println(frac + "  " + i);
			}
			
		}
		long t2 = System.currentTimeMillis();
		System.out.println(min + "  " + myn);
		System.out.println(primes);
		System.out.println(("TIME:" + (t2 - t1) + "millisec"));
	}
}
