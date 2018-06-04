import java.util.Vector;

public class problem47 {
	public static int isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return i;
		}
		return 0;
	}

	static Vector<Integer> primes = new Vector<Integer>();

	public static int getCount(int X, int i) {
		if (isPrime(X) == 0)
			return 1;
		if (X == 1)
			return 0;
		int p = primes.get(i);
		if (X % p == 0) {
			while (X % p == 0)
				X = X / p;
			if (X != 1)
				return 1 + getCount(X, i + 1);
			else
				return getCount(X, i + 1);

		} else {
			return getCount(X, i + 1);
		}
	}

	public static void main(String args[]) {
		int max = 1000000, k = 4;
		primes.add(2);
		for (int i = 3; i < max; i = i + 2) {
			if (isPrime(i) == 0) {
				primes.add(i);
			}
		}
		
		for (int i = 10; i < max - k; i++) {
			int flag = 1;
			for (int j = i; j < i + k; j++) {
				if (getCount(j, 0) != k) {
					flag = 0;
					break;
				}
			}
			
			if (flag == 1) {
				for (int j = i; j < i + k; j++) 
					System.out.print(j + "  ");
				break;
			}
		}
	}
}
