package euler;
class problem28 {
	public static void main(String args[]) {

		long t10 = System.currentTimeMillis();
		int n = 1001;
		long sum1 = 0, sum2 = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1)
				sum1 = sum1 + i * i;

			if (i % 2 == 0)
				sum2 = sum2 + i * i + 1;

		}
		int t = 3, tau1 = t + 4, sumt1 = 0, sumtau1 = 0;
		for (int i = 1; i <= n / 2; i++) {
			sumt1 += t;
			sumtau1 += tau1;
			t = t + 8 * i + 2;
			tau1 = t + 4 * (i + 1);
		}
		System.out.println((sumt1 + sumtau1 + sum1 + sum2));
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t10) + " millisec");
	}
}