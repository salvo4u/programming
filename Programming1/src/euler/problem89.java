package euler;

public class problem89 {
	public static void main(String args[]) {
		int N = 7;
		int sum = 0;
		long t1 = System.currentTimeMillis();
		while (true) {
			if (sum > 2000)
				break;
			sum = 0;
			N++;
			for (int i = 1; i <= N; i++) {
				double D = Math.sqrt((i + i) * (i + i) + i * i);
				if ((D - (int) D) == 0)
					sum++;
			}
			System.out.println(N + "  " + sum);
			
		}

		long t2 = System.currentTimeMillis();
		System.out.println((t2 - t1));
	}
}
