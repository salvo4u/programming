public class problem73 {
	
	static int GCD(int a, int b) {
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		if (a == 0 || b == 1 || a == b)
			return b;
		if (a == 1 || b == 0)
			return a;
		if (a > b)
			return GCD(b, a % b);
		else
			return GCD(a, b % a);
	}
	
	public static void main(String args[]) {
		int N = 12000, count = 0;
		long t1=System.currentTimeMillis();
		double lower = (double) (1.0 / 3.0);
		double upper = (double) (1.0 / 2.0);
		for (double i = 1; i <= N; i++) {
			for (double j = i + 1; j <= N; j++) {
				if (GCD((int) i, (int) j) == 1) {
					double frac = (double) (i / j);
					if (frac > lower && frac < upper)
					{
						count++;
					}	
				}
			}
		}
		long t2=System.currentTimeMillis();
		System.out.println(count+"  time(ms):"+(t2-t1));
	}
}
