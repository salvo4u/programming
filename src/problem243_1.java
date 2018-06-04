import java.util.ArrayList;
import java.util.List;
public class problem243_1 {
	public static List<Integer> primes = new ArrayList<Integer>();

	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		float L = (float) 15499 / 94744;
		primes.add(2);
		for (int i = 3; i < 2000000; i++) {
			if (isPrime(i))
				primes.add(i);
		}
		int phin;
		for (int d = 1000000; ; d++) {
			float prod = 1;
			for (int j = 0; j < primes.size(); j++) {
				int prime = primes.get(j);

				if (prime > d)
					break;

				if (d % prime == 0)
					prod = prod * (1 - 1 / (float) prime);
			}
			phin = (int) Math.ceil(prod * d);
			float rd = (float) phin / (d - 1);
			System.out.println(d + "  " + phin + "  " + rd);
			if (rd < L) {
				System.out.println(d);
				break;
			}
		}
	}
}
