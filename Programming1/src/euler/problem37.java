package euler;
import java.util.ArrayList;
import java.util.List;

public class problem37 {
	static List<Long> primes = new ArrayList<Long>();

	public static boolean isPrime(long n) {
		if (n == 1)
			return false;
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	public static String reverseIt(String source) {
		int i, len = source.length();
		StringBuffer dest = new StringBuffer(len);

		for (i = (len - 1); i >= 0; i--)
			dest.append(source.charAt(i));
		return dest.toString();
	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis(),sum=0;
		primes.add((long) 2);
		for (int i = 3; i < 1000000; i = i + 2) {
			if (isPrime(i))
				primes.add((long) i);
		}
		int count=0;
		for (int i = 4; i < primes.size(); i++) {
			String x = primes.get(i) + "";
			String revx = reverseIt(x);
			boolean flag1 = true, flag2 = true;
			for (int j = 0; j < x.length(); j++) {
				String n1 = x.substring(0, j + 1);
				Long l1 = new Long(n1);
				if (!primes.contains(l1)) {
					flag1 = false;
					break;
				}
			}
			for (int j = 0; j < revx.length(); j++) {
				String n1 = reverseIt(revx.substring(0, j + 1));
				Long l1 = new Long(n1);
				if (!primes.contains(l1)) {
					flag2 = false;
					break;
				}
			}
			if(flag2 && flag1){
				count++;
				sum+=primes.get(i);
			}
			if(count==11)
				break;
		}
		System.out.println(sum);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
