import java.util.ArrayList;

public class problem50_2 {
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
		ArrayList<Long> sump = new ArrayList<Long>();
		p.add(2);
		long psum = 2;
		sump.add(psum);
		long t1 = System.currentTimeMillis();
		for (int i = 3; i <= N; i = i + 2) {
			if (isPrime(i)) {
				psum = psum + i;
				p.add(i);
				sump.add(psum);
			}
		}
		long max = 0;
		long myprime = 0;
		
		for (int k = 0; k < p.size(); k++) {
			int prime = p.get(k);
			for (int length = 1; length <= p.size(); length++) {
				for (int start = 0; start < p.size() - length; start++) {
					int end = start + length;
					long sum = sump.get(end) - sump.get(start);
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
		System.out.println(myprime+"  "+max);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
