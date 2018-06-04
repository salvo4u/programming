package euler;
class problem27_2 {
	public static boolean isPrime(int a, int b, int n) {
		long num = n * n + a * n + b;
		if (num < 0)
			num = num * -1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {

		long t1 = System.currentTimeMillis();
		int max = 0, maxa = 0, maxb = 0, N = 1000;
		for (int a = -N + 1; a < N; a = a + 2) {
			for (int b = -N; b < N; b++) {
				int n = 0;
				while (isPrime(a, b, n) && isPrime(0, b, 0))
					n++;

				if (max < n) {
					max = n;
					maxa = a;
					maxb = b;
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(maxa * maxb);
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}