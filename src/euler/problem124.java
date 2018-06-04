package euler;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
public class problem124 {
	public static List<Integer> primes = new ArrayList<Integer>();
	public static TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	static int breakUp(int n) {
		int p = 0;
		int prod = 1;
		while (n != 1) {
			int prime1 = primes.get(p++);
			int flag = 0;
			while (n % prime1 == 0) {
				n = n / prime1;
				flag = 1;
			}
			if (flag == 1)
				prod = prod * prime1;
		}
		return prod;
	}

	private static void initializeMap(int N) {
		for (int i = 2; i <= N; i++) {
			int radn = breakUp(i);
			if (map.get(radn) == null) {
				List<Integer> mylist = new ArrayList<Integer>();
				map.put(radn, mylist);
			}
			map.get(radn).add(i);
		}
	}

	private static void initializaPrimes(int N) {
		for (int i = 2; i <= N; i++) {
			if (isPrime(i))
				primes.add(i);
		}
	}

	public static void main(String args[]) {
		int N = 100000;
		long t1 = System.currentTimeMillis();
		initializaPrimes(N);
		initializeMap(N);
		Iterator<Integer> it = map.keySet().iterator();
		int lineno = 2;
		int ans = 1;
		while (it.hasNext()) {
			int key = it.next(),flag=0;
			List<Integer> l = map.get(key);
			for (int i = 0; i < l.size(); i++) {
				if (lineno == 10000) {
					ans = l.get(i);
					flag=1;
					System.out.println(ans);
					break;
				}
				lineno++;
			}
			if(flag==1)
				break;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: "+(t2 - t1) + " millisec");
	}
}
