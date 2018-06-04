package codechef;

import java.util.Scanner;
import java.util.TreeMap;

public class Bytelandian {
	static float TWO = 2;
	static float THREE = 3;
	static float FOUR = 4;
	//static TreeMap<Long, Long> hmap = new TreeMap<Long, Long>();

	static long coinExchange(long n) {
		if (n <= 11)
			return n;
		/*Long x = hmap.get(n);
		if (x != null)
			return x;
*/
		float half = n / TWO;
		float third = n / THREE;
		float fourth = n / FOUR;
		long bankex = coinExchange((long) half) + coinExchange((long) third)
				+ coinExchange((long) fourth);
		long val = bankex > n ? bankex : n;
		//hmap.put(n, val);
		return val;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			Long a = new Long(s);
			System.out.println(coinExchange(a));
		}
		scanner.close();
	}
}
