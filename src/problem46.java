import java.util.HashMap;
import java.util.Vector;

public class problem46 {
	public static int isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return i;
		}
		return 0;
	}

	public static boolean isPerfectSquare(long n) {
		if (n < 0)
			return false;

		long tst = (long) (Math.sqrt(n) + 0.5);
		return tst * tst == n;
	}

	public static void main(String args[]) {
		int max=10000;
		Vector<Integer> primes = new Vector<Integer>();
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		primes.add(2);
		hmap.put(2, 1);

		int count = 2, prevp = 5;
		for (int i = 3; i < max; i=i+2) {
			if (isPrime(i) == 0) {
				count++;
				primes.add(i);
				prevp=i;
			}
		}
		
		System.out.println(primes);
		System.out.println(hmap);
		
		boolean c = true;
		int odd = 33;
		while (c != false) {
			odd = odd + 2;
			if(isPrime(odd)==0)
				continue;
			c = false;
			int j=0,p;
				while((p=primes.get(j))<odd)
				{
				j++;
				int diff = (odd - p) / 2;
				if (isPerfectSquare(diff)) {
					c = true;
					System.out.println(odd+" = "+p+" + 2*"+diff+"");
					break;
				}
			}
		}
		System.out.println(odd);
	}

}
